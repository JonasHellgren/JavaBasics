package java_design_patterns.Q_command.remote_control;

public class RemoteControl {
    Command slot;  // only one button

    public RemoteControl()
    {
    }

    public void selectButton(Command command)
    {
        slot = command;
    }

    public void pressButton()
    {
        slot.execute();
    }
}
