package pluralsight_courses.pluralsight_java_basics.calcengine1;

public class MathEquation {
    public double leftVal = 0.0d;
    public double rightVal = 0.0d;
    public char opCode = 'a';
    public double result;

    public void execute() {
        switch (opCode) {
            case 'a':
                result = leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'd':
                result = (rightVal == 0.0) ? 0.0 : leftVal / rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            default:
                System.out.println("Error - Invalid opcode");
                result = 0.0d;
                break;
        }

    }
}
