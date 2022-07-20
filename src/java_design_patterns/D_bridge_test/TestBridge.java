package java_design_patterns.D_bridge_test;

import java_design_patterns.D_bridge.bridge.*;
import org.junit.Test;

public class TestBridge {

    @Test
    public void test() {

        ImplementationInterface imp1 =new Implementation1();
        ImplementationInterface imp2 =new Implementation2();

        Abstraction a1=new ConcreteAbstraction(imp1);
        a1.CallMethod1();

        Abstraction a2=new ConcreteAbstraction(imp2);
        a2.CallMethod1();

    }

}
