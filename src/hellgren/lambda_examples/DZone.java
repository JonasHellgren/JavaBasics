package hellgren.lambda_examples;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class DZone {

    @FunctionalInterface
    public interface SquareRoot {
        abstract double findSquareRoot(int n);
    }

    static  class ParData  {

        double m;
        double CdA;

        public ParData(double m, double cdA) {
            this.m = m;
            CdA = cdA;
        }
    }


    static  class MathFunctions {

        static ParData par;

        static SquareRoot squareRoot = (n) -> (Math.sqrt(n));
        static Function<Double, Double> square = (n) -> Math.pow(n,2);
        static UnaryOperator<Double> cube = (n) -> Math.pow(n,3);
        static Function<Double, Double> force = (a) -> par.m*a;
    }

    public static void main(String[] args) {

        ParData par=new ParData(1000, 0.5);

        MathFunctions.par=par;


        System.out.println(MathFunctions.squareRoot.findSquareRoot(100));
        System.out.println("MathFunctions.square.apply(5) = " + MathFunctions.square.apply(5d));
        System.out.println("MathFunctions.cube.apply(3) = " + MathFunctions.cube.apply(3d));
        System.out.println("MathFunctions.force.apply(1d) = " + MathFunctions.force.apply(-1d));


    }

}
