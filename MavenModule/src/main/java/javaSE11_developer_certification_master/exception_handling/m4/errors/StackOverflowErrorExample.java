package javaSE11_developer_certification_master.exception_handling.m4.errors;

public class StackOverflowErrorExample {

    public static void main(String[] args) {
        calculate(1, 2);
    }

    private static void calculate(int a, int b) {
        calculate(a, b);
    }
}
