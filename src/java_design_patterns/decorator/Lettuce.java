package java_design_patterns.decorator;

public class Lettuce extends ToppingDecorator {
    Sandwich sandwich;
    public Lettuce(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public String getDescription() {
        return sandwich.getDescription() + ", Lettuce";
    }
    public double cost() {
        return sandwich.cost() + 0.8;
    }
}
