package youtube.avoiding_if_else_command_pattern.clean;

import youtube.avoiding_if_else_command_pattern.bad.CommandRunnerBad;
import youtube.avoiding_if_else_command_pattern.clean.executors.BalanceCommandExecutor;
import youtube.avoiding_if_else_command_pattern.clean.executors.CommandExecutor;
import youtube.avoiding_if_else_command_pattern.clean.executors.RechargeCommandExecutor;
import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.RechargeProvider;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

import java.util.ArrayList;
import java.util.List;

public class CommandRunnerGood {

    List<CommandExecutor> commandExecutors;

    public CommandRunnerGood(List<CommandExecutor> commandExecutors) {
        this.commandExecutors = commandExecutors;
    }

    public static CommandRunnerGood newCommandRunnerGood() {
        UserDataBase dataBase=new UserDataBase();
        List<CommandExecutor> commandExecutors=new ArrayList<>();
        commandExecutors.add(new BalanceCommandExecutor(dataBase));
        commandExecutors.add(new RechargeCommandExecutor(dataBase, new RechargeProvider()));
        return new CommandRunnerGood(commandExecutors);
    }

    public String runCommand(Command command) throws IllegalArgumentException {
        for (CommandExecutor commandExecutor: commandExecutors) {
            if (commandExecutor.isApplicable(command)) {
                return commandExecutor.execute(command);
            }
        }

        throw new IllegalArgumentException("No matching command");
    }

}
