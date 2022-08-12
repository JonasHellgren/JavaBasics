package youtube.avoiding_if_else_command_pattern.clean.executors;
import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

abstract public class CommandExecutor {

    protected UserDataBase database;

    public CommandExecutor(UserDataBase database) {
        this.database = database;
    }

    public String execute(final Command command) {
        if (!isValid(command)) {
            throw new IllegalArgumentException("No valid command");
        }
        return executeValidCommand(command);
    }

    public abstract Boolean isApplicable(final Command command);

    protected abstract Boolean isValid(final Command command);

    protected abstract String executeValidCommand(final Command command);
}
