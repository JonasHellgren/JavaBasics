package java_design_patterns.decorator;

import lombok.Getter;

@Getter
public abstract class Sandwich {
    String description;
    public abstract double cost();
}
