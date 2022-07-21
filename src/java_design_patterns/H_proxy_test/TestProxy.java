package java_design_patterns.H_proxy_test;

import java_design_patterns.H_proxy.ExpensiveObject;
import java_design_patterns.H_proxy.ExpensiveObjectInterface;
import java_design_patterns.H_proxy.ExpensiveObjectProxy;
import org.junit.Test;

public class TestProxy {

    @Test
    public void test() {
        ExpensiveObjectInterface object = new ExpensiveObjectProxy();
        object.process();
        object.process();  //no initial configuration this time
    }
}
