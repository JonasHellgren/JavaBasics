package effective_java.J_exceptions_tests.examples;

import effective_java.J_exceptions.examples.StudentCheck;
import org.junit.Test;

public class TestStudentCheck {

    @Test
    public void test() {
        System.out.println("Welcome to the Registration process!!");
        StudentCheck.checkEligibilty(10, 39);
        System.out.println("Have a nice day..");
    }

    /**
     * java.lang.ArithmeticException: Student is not eligible for registration
     *
     * 	at effective_java.J_exceptions.examples.StudentCheck.checkEligibilty(StudentCheck.java:6)
     * 	at effective_java.J_exceptions_tests.examples.TestStudentCheck.test(TestStudentCheck.java:11)
     */


}
