package apache.runners;


import org.apache.commons.lang3.math.Fraction;

public class FractionDemo {

    public static void main(String[] args) {
        var f1div2=Fraction.getFraction(1,2);
        var fSum=f1div2.add(f1div2);
        System.out.println("fSum = " + fSum);

        var fMult=f1div2.multiplyBy(f1div2);
        System.out.println("fMult = " + fMult);

    }
}
