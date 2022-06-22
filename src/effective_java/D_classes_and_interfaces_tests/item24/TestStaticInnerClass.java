package effective_java.D_classes_and_interfaces_tests.item24;

import effective_java.D_classes_and_interfaces.item24.OuterClass;
import org.junit.Assert;
import org.junit.Test;

public class TestStaticInnerClass {

    public static final int NUM_VAL = 10;

    @Test
    public void test() {
        OuterClass.setI(NUM_VAL);
        OuterClass.InnerClass.printNum();
        Assert.assertEquals(10,OuterClass.InnerClass.getNum());

    }
}
