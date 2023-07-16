package ps_new_in_java17_junit5.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class TimeOutTest {

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void givenMax100Millis_whenRunning99Millis_thenNotFail() throws InterruptedException {
        Thread.sleep(99);
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void givenMax100MillisSeparateThread_whenRunning99Millis_thenNotFail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(99);
    }

}
