package java_design_patterns.decorator;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chicken extends ToppingDecorator {
    Sandwich sandwich;

    public String getDescription() {
        return sandwich.getDescription() + ", Chicken";
    }
    public double cost() {
        return sandwich.cost() + 1;
    }
}


