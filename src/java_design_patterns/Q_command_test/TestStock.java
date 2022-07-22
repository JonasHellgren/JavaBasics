package java_design_patterns.Q_command_test;

import java_design_patterns.Q_command.stock.*;
import org.junit.Assert;
import org.junit.Test;

public class TestStock {

    @Test
    public void test() {
        Stock aStock = new Stock("A",10L);
        Stock bStock = new Stock("B",5L);

        Order buyAStockOrder = new BuyStock(aStock);
        Order sellAStockOrder = new SellStock(aStock);
        Order buyBStockOrder = new BuyStock(bStock);
        Order sellBStockOrder = new SellStock(bStock);

        Broker broker = new Broker();
        broker.takeOrder(buyAStockOrder);
        broker.takeOrder(buyAStockOrder);
        broker.takeOrder(buyAStockOrder);
        broker.takeOrder(sellAStockOrder);
        broker.takeOrder(buyBStockOrder);
        broker.takeOrder(sellBStockOrder);

        Assert.assertEquals(6,broker.nofOrders());
        broker.runOrders();
        Assert.assertEquals(0,broker.nofOrders());

    }
}
