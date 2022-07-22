package java_design_patterns.Q_command.remote_control;

public class LightOffCommand implements Command {
    Light light;
    public LightOffCommand(Light light)
    {
        this.light = light;
    }
    public void execute()
    {
        light.off();
    }
}
