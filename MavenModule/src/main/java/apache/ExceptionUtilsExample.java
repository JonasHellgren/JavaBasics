package apache;

import org.apache.commons.lang3.exception.ExceptionUtils;

public class ExceptionUtilsExample {
    public static void main(String[] args) {
        try {
            // Code that may throw an exception
        } catch (Exception e) {
            // Get the root cause of the exception
            Throwable rootCause = ExceptionUtils.getRootCause(e);
            System.out.println(rootCause);

            // Get the stack trace as a string
            String stackTrace = ExceptionUtils.getStackTrace(e);
            System.out.println(stackTrace);
        }
    }
}
