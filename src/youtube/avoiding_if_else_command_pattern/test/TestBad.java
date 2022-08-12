package youtube.avoiding_if_else_command_pattern.test;

import org.junit.Test;
import youtube.avoiding_if_else_command_pattern.bad.CommandRunnerBad;
import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.CommandTypes;
import youtube.avoiding_if_else_command_pattern.common.RechargeProvider;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

import java.util.Arrays;

public class TestBad {


    @Test public void test() {

        CommandRunnerBad crb=new CommandRunnerBad(new UserDataBase(), new RechargeProvider());
        Command command=new Command(CommandTypes.BALANCE, Arrays.asList("Jonas"));
        String reply=crb.runCommand(command);
        System.out.println("reply = " + reply);

    }

}
