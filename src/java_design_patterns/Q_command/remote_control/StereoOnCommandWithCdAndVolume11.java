package java_design_patterns.Q_command.remote_control;

public class StereoOnCommandWithCdAndVolume11 implements Command {
    public static final int VOLUME = 11;
    Stereo stereo;
    public StereoOnCommandWithCdAndVolume11(Stereo stereo)
    {
        this.stereo = stereo;
    }
    public void execute()
    {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(VOLUME);
    }
}

