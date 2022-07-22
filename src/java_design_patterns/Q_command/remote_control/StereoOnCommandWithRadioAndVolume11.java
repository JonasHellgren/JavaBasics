package java_design_patterns.Q_command.remote_control;

public class StereoOnCommandWithRadioAndVolume11 implements Command {
    public static final int VOLUME = 11;
    Stereo stereo;
    public StereoOnCommandWithRadioAndVolume11(Stereo stereo)
    {
        this.stereo = stereo;
    }
    public void execute()
    {
        stereo.on();
        stereo.setRadio();
        stereo.setVolume(VOLUME);
    }
}
