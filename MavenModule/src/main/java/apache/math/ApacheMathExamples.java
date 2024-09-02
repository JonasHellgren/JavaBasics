package apache.math;

import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Cos;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.commons.math3.analysis.function.Log;
import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.analysis.function.Sqrt;
import org.apache.commons.math3.analysis.function.Subtract;
import org.apache.commons.math3.analysis.function.Tan;
import org.apache.commons.math3.analysis.function.Abs;
import org.apache.commons.math3.analysis.function.Acos;
import org.apache.commons.math3.analysis.function.Asin;
import org.apache.commons.math3.analysis.function.Atan;
import org.apache.commons.math3.analysis.function.Ceil;
import org.apache.commons.math3.analysis.function.Floor;
import org.apache.commons.math3.analysis.function.Pow;
import org.apache.commons.math3.analysis.function.Rint;
import org.apache.commons.math3.analysis.function.Signum;

public class ApacheMathExamples {
    private static Add add = new Add();
    private static Subtract subtract = new Subtract();
    private static Sin sin = new Sin();
    private static Cos cos = new Cos();
    private static Tan tan = new Tan();
    private static Asin asin = new Asin();
    private static Acos acos = new Acos();
    private static Atan atan = new Atan();
    private static Exp exp = new Exp();
    private static Log log = new Log();
    private static Sqrt sqrt = new Sqrt();
    private static Pow pow = new Pow();
    private static Abs abs = new Abs();
    private static Signum signum = new Signum();
    private static Ceil ceil = new Ceil();
    private static Floor floor = new Floor();
    private static Rint rint = new Rint();

    public static void main(String[] args) {
        // Basic math functions
        System.out.println("Addition: " + add.value(2, 3));
        System.out.println("Subtraction: " + subtract.value(5, 2));
        System.out.println("Multiplication: " + pow.value(2, 3));
        System.out.println("Division: " + pow.value(6, -1));

        // Trigonometric functions
        System.out.println("Sine: " + sin.value(Math.PI / 2));
        System.out.println("Cosine: " + cos.value(Math.PI));
        System.out.println("Tangent: " + tan.value(Math.PI / 4));

        // Inverse trigonometric functions
        System.out.println("Arcsine: " + asin.value(1));
        System.out.println("Arccosine: " + acos.value(-1));
        System.out.println("Arctangent: " + atan.value(1));

        // Exponential and logarithmic functions
        System.out.println("Exponential: " + exp.value(2));
        System.out.println("Natural logarithm: " + log.value(Math.E));

        // Power and root functions
        System.out.println("Square root: " + sqrt.value(4));
        System.out.println("Cube root: " + pow.value(27, 1.0 / 3.0));

        // Absolute value and signum functions
        System.out.println("Absolute value: " + abs.value(-3));
        System.out.println("Signum: " + signum.value(-3));

        // Rounding functions
        System.out.println("Ceiling: " + ceil.value(3.7));
        System.out.println("Floor: " + floor.value(3.7));
        System.out.println("Rint: " + rint.value(3.7));
    }
}