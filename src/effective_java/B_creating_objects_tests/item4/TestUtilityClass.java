package effective_java.B_creating_objects_tests.item4;

import effective_java.B_creating_objects.item4.UtilityClass;
import org.junit.Test;

public class TestUtilityClass {

    @Test
    public void testHello() {
        UtilityClass.printHello();
    }

    @Test(expected = AssertionError.class)
    public void testInitiate() {
        UtilityClass utilityClass=new UtilityClass();
    }

}
