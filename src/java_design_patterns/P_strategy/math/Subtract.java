package java_design_patterns.P_strategy.math;

public class Subtract implements Strategy {
        @Override
        public int operate(int num1, int num2) {
            return num1 - num2;
        }
}
