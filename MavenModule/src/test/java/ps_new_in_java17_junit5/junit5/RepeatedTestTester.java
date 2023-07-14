package ps_new_in_java17_junit5.junit5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RepeatedTestTester {

    @RepeatedTest(value=5)
    public void test5Times() {
        Assertions.assertTrue(true);
    }

}
