package java_design_patterns.Q_command_test;

import java_design_patterns.Q_command.home_automation.*;
import org.junit.Test;

public class TestHomeAutomation {

    public static final String LIVING_ROOM = "living room";
    public static final String BED_ROOM = "bed room";

    @Test
    public void test() {

        Light livingRoomLight = new Light(LIVING_ROOM);  //receiver 1
        Fan livingRoomFan = new Fan(LIVING_ROOM);  //receiver 2
        Light bedRoomLight = new Light(BED_ROOM); //receiver 3
        Fan bedRoomFan = new Fan(BED_ROOM);   //receiver 4
        RemoteController remote = new RemoteController(); //Invoker

        remote.setCommand(new CommandTurnOnLight( livingRoomLight ));
        remote.buttonPressed();

        remote.setCommand(new CommandTurnOnLight( bedRoomLight ));
        remote.buttonPressed();

        remote.setCommand(new CommandStartFan( livingRoomFan ));
        remote.buttonPressed();

        remote.setCommand(new CommandStopFan( livingRoomFan ));
        remote.buttonPressed();

        remote.setCommand(new CommandStartFan( bedRoomFan ));
        remote.buttonPressed();

        remote.setCommand(new CommandStopFan( bedRoomFan ));
        remote.buttonPressed();
    }
}
