package java_design_patterns.Q_command.stock;

public class BuyStock  implements Order {
    private final Stock abcStock;

    public BuyStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.buy();
    }
}
