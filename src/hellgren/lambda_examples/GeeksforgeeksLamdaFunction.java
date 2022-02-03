package hellgren.lambda_examples;

public class GeeksforgeeksLamdaFunction {

    @FunctionalInterface
    interface FunctionTwoArgs  {
        int apply(int a, int b);
    }

    private static int operateOnTwoArgs(int a, int b, FunctionTwoArgs fcn) {
        return fcn.apply(a,b);
    }

    public static void main(String[] args) {

    FunctionTwoArgs add=(a,b) -> a+b;
    FunctionTwoArgs mult=(a,b) -> a*b;

    System.out.println("operateOnTwoArgs(2,3,add) = " + operateOnTwoArgs(2, 3, add));
    System.out.println("operateOnTwoArgs(2,3,mult) = " + operateOnTwoArgs(2, 3, mult));


    }
}
