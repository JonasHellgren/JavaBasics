package javaSE11_developer_certification_master.exception_handling.m4.errors;

public class NoClassDefFoundErrorExample {

    public static void main(String[] args) {
        try {
            new Calculator(); //  ExceptionInInitializerError
        } catch (Throwable t) {
            System.out.println(t); // swallow the above exception
        }
        new Calculator(); // NoClassDefFoundError
    }

    public static class Calculator {
        static int undefined = 1 / 0;
    }
}
