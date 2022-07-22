package java_design_patterns.P_strategy.math;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.operate(num1, num2);
    }
}
