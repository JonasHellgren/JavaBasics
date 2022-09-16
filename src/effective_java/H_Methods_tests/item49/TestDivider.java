package effective_java.H_Methods_tests.item49;

import effective_java.H_Methods.item49.Divider;
import org.junit.Test;

public class TestDivider {


    @Test
    public void test() {
        Double res= Divider.div(2,3);
        System.out.println("res = " + res);
    }

    @Test
    public void testDiv0() {
        Double res= Divider.div(2,0);
        System.out.println("res = " + res);
    }


    //requires VM option -ea
    @Test(expected = AssertionError.class)
    public void testZeroDenom() {
        Double res= Divider.div(2,0);
        System.out.println("res = " + res);
    }

}
