package youtube.avoiding_if_else_command_pattern.clean.executors;

import java_design_patterns.E_singleton.Database;
import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.RechargeProvider;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

public class RechargeCommandExecutor extends CommandExecutor {
    RechargeProvider rechargeProvider;

    public RechargeCommandExecutor(UserDataBase database, RechargeProvider rechargeProvider) {
        super(database);
        this.rechargeProvider = rechargeProvider;
    }

    public Boolean isApplicable(Command command) {
        return command.getName().equals("recharge");
    }

    protected Boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }

    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

        Integer userBalance = database.getUsreBalance(user);
        if (userBalance < rechargeAmount) {
            return "Not sufficient balance";
        }
        rechargeProvider.recharge(user, rechargeAmount);
        return "Recharge Done";

    }
}
