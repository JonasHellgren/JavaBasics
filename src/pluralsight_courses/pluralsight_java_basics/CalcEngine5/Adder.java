package pluralsight_courses.pluralsight_java_basics.CalcEngine5;

public class Adder implements MathProcessing {

    //define methods "requested" by interface MathProcessing
    @Override
    public String getKeyword()  {return "add"; }

    @Override
    public char getSymbol() {return '+'; }

    @Override
    public double doCalculation(double leftVal,double rightVal) {
        return leftVal+rightVal; }

}
