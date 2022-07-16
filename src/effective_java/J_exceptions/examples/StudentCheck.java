package effective_java.J_exceptions.examples;

public class StudentCheck {

    public static final int AGE_MIN = 12;
    public static final int WEIGHT_MIN = 40;

    public static void checkEligibilty(int age, int weight) {
        if (age < AGE_MIN && weight < WEIGHT_MIN) {
            throw new ArithmeticException("Student is not eligible for registration");
        } else {
            System.out.println("Student Entry is Valid!!");
        }
    }
}
