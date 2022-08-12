package youtube.avoiding_if_else_command_pattern.clean.executors;

import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.CommandTypes;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

public class BalanceCommandExecutor extends CommandExecutor{

    public BalanceCommandExecutor(UserDataBase database) {
        super(database);
    }

    public Boolean isApplicable(Command command) {
        return command.getType().equals(CommandTypes.BALANCE);
    }

    protected Boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }

    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        return database.getUsreBalance(user).toString();
    }
}
