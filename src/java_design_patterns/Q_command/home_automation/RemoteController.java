package java_design_patterns.Q_command.home_automation;

public class RemoteController {
    //Command Holder
    CommandInterface command;

    //Set the command in runtime to trigger.
    public void setCommand(CommandInterface command) {
        this.command = command;
    }

    //Will call the command interface method so that particular command can be invoked.
    public void buttonPressed() {
        command.execute();
    }
}
