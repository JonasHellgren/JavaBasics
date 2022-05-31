package hellgren.lambda_examples.dzoneclasses;

import com.sun.source.tree.BreakTree;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.function.Function;
import java.util.function.UnaryOperator;


@Getter
public class MathFunctions {

    private VehicleParameters par;

    @FunctionalInterface
    public interface SquareRoot {
        double findSquareRoot(int n);
    }

    public MathFunctions(VehicleParameters par) {
        this.par = par;
    }

    public SquareRoot squareRoot = (n) -> (Math.sqrt(n));
    public Function<Double, Double> square = (n) -> Math.pow(n, 2);
    public UnaryOperator<Double> cube = (n) -> Math.pow(n, 3);
    public Function<Double, Double> force = (a) -> par.mass * a;


}
