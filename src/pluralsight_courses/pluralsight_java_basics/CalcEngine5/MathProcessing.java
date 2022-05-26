package pluralsight_courses.pluralsight_java_basics.CalcEngine5;

public interface MathProcessing {
    String SEPERATOR = " ";
    char SPACE = ' ';
    String getKeyword();    //for handling e.g. add
    char getSymbol();       //for handling e.g. + symbol
    double doCalculation(double leftVal, double rightVal);
}
