package java_design_patterns.decorator;

public class WholeWheat extends Sandwich {
    public WholeWheat() {
        description = "Whole Wheat Sandwich";
    }
    public double cost() {
        return 1.5;
    }
}
