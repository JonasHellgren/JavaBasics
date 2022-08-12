package youtube.avoiding_if_else_command_pattern.bad;


import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.RechargeProvider;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

public class CommandRunnerBad {
    final UserDataBase database;
    final RechargeProvider rechargeProvider;

    public CommandRunnerBad(UserDataBase database, RechargeProvider rechargeProvider) {
        this.database = database;
        this.rechargeProvider = rechargeProvider;
    }

    public String runCommand(Command command) {
        if ("balance".equals(command.getName())) {
            if (command.getParams().size() != 1) {
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            return database.getUsreBalance(user).toString();
        } else if ("recharge".equals(command.getName())) {
            if (command.getParams().size() != 2) {
                return "Invalid Command";
            }
            String user = command.getParams().get(0);
            Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));

            Integer userBalance = database.getUsreBalance(user);
            if (userBalance < rechargeAmount) {
                return "Not sufficient balance";
            }
            rechargeProvider.recharge(user, rechargeAmount);
            return "Recharge Done";
        } else {
            return "Invalid command";
        }
    }

}
