package java_design_patterns.N_template_test;

import java_design_patterns.N_template.order.NetOrder;
import java_design_patterns.N_template.order.OrderProcessInterface;
import java_design_patterns.N_template.order.StoreOrder;
import org.junit.Test;

public class TestStore {

    @Test
    public void test() {
        OrderProcessInterface netOrder = new NetOrder();
        netOrder.processOrder(true);
        System.out.println();
        OrderProcessInterface storeOrder = new StoreOrder();
        storeOrder.processOrder(true);
    }

}


