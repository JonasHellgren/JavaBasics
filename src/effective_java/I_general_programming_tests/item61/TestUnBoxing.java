package effective_java.I_general_programming_tests.item61;

import effective_java.I_general_programming.item61.Timer;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class TestUnBoxing {

    @Test
    public void unBoxingSlowsDown()  {
        Timer timer=Timer.createTimer();
        Long sum = 0L;          //No primitive gives later unboxing
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("Time need with unboxing = "+timer.getElapsed(TimeUnit.SECONDS));
    }


    @Test
    public void noUnBoxingSpeedsUp()  {
        Timer timer=Timer.createTimer();
        long sum = 0L;
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        System.out.println("Time need without unboxing = "+timer.getElapsed(TimeUnit.SECONDS));
    }

}
