package java_design_patterns.decorator;

public class Multigrain extends Sandwich {
    public Multigrain() {
        description = "Multigrain Sandwich";
    }
    // Difference is here
    public double cost() {
        return 1.8;
    }
}
