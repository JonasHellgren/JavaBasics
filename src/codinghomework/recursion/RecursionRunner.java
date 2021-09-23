package codinghomework.recursion;

import java.util.Scanner;

public class RecursionRunner {

    public static void main(String[] args) {
        int n=requestNumber();
        System.out.println("Factorial of n "+n+" is "+calcFactorial(n));
    }

     static int requestNumber() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter integer:");
        return Integer.parseInt(scanner.nextLine());
    }

    static int calcFactorial(int n) {
        if (n == 1)
            return 1;

        return n*calcFactorial(n - 1);
    }
}
