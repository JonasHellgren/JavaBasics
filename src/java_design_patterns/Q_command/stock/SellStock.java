package java_design_patterns.Q_command.stock;

public class SellStock implements Order {
    private final Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
