package java_design_patterns.Q_command.stock;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public int nofOrders() {
        return orderList.size();
    }

    public void runOrders(){

        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
