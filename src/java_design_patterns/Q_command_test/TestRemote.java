package java_design_patterns.Q_command_test;

import java_design_patterns.Q_command.remote_control.*;
import org.junit.Test;

public class TestRemote {

    @Test
    public void test() {
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        // we can change command dynamically
        remote.selectButton(new LightOnCommand(light));
        remote.pressButton();
        remote.selectButton(new StereoOnCommandWithCdAndVolume11(stereo));
        remote.pressButton();
        remote.selectButton(new StereoOffCommand(stereo));
        remote.pressButton();
        remote.selectButton(new StereoOnCommandWithRadioAndVolume11(stereo));
        remote.pressButton();
    }

}
