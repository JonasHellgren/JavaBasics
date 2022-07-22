package java_design_patterns.Q_command.remote_control;

public class StereoOffCommand implements Command {
    Stereo stereo;
    public StereoOffCommand(Stereo stereo)
    {
        this.stereo = stereo;
    }
    public void execute()
    {
        stereo.off();
    }
}


