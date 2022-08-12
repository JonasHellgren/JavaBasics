package youtube.avoiding_if_else_command_pattern.test;

import org.junit.Assert;
import org.junit.Test;
import youtube.avoiding_if_else_command_pattern.bad.CommandRunnerBad;
import youtube.avoiding_if_else_command_pattern.clean.CommandRunnerGood;
import youtube.avoiding_if_else_command_pattern.clean.executors.BalanceCommandExecutor;
import youtube.avoiding_if_else_command_pattern.clean.executors.CommandExecutor;
import youtube.avoiding_if_else_command_pattern.clean.executors.RechargeCommandExecutor;
import youtube.avoiding_if_else_command_pattern.common.Command;
import youtube.avoiding_if_else_command_pattern.common.CommandTypes;
import youtube.avoiding_if_else_command_pattern.common.RechargeProvider;
import youtube.avoiding_if_else_command_pattern.common.UserDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGood {


    @Test public void testBalance() {

        CommandRunnerGood cr=CommandRunnerGood.newCommandRunnerGood();
        Command command=new Command(CommandTypes.BALANCE, Arrays.asList("Jonas"));
        String reply=cr.runCommand(command);
        System.out.println("reply = " + reply);

        Assert.assertEquals("1000",reply);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testNoCommand()
    {

        CommandRunnerGood cr=CommandRunnerGood.newCommandRunnerGood();
        Command command=new Command(CommandTypes.DUMMY, Arrays.asList("Jonas"));
        String reply=cr.runCommand(command);
        System.out.println("reply = " + reply);

        Assert.assertEquals("1000",reply);

    }



}
