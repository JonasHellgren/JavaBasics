package mobilapp_java_receipes.flowcontrol;

import org.junit.Assert;
import org.junit.Test;

public class TestBreakAndContinue {

    @Test
    public void whenBreaking_thenCorrect() {

        int[] numbers = {2, 3, 5, 7, 11, 13, 17, 19};
        int lastNum=0;
        for (int number : numbers)
        {
            if (number > 10)
                break;
            lastNum=number;   //not executed if number > 10
        }

        System.out.println("lastNum = " + lastNum);
        Assert.assertTrue(lastNum<10);

    }

    @Test
    public void whenContinue_thenCorrect() {

        int[] numbers = {2, 3, 5, 7, 11, 13, 17, 19};
        int lastNum=0;
        for (int number : numbers)
        {
            if (number < 10)
                continue;
            lastNum=number;   //not executed if number < 10
            System.out.println("lastNum = " + lastNum);

        }

        //prints 11,...,19

        Assert.assertEquals(19,lastNum);

    }

}
