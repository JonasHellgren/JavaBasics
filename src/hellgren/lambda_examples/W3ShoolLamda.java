package hellgren.lambda_examples;

import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Consumer;

public class W3ShoolLamda {


    @FunctionalInterface
    interface  StringFunction {
        String run(String str);
    }

    public static void printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
    }

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(9);
        numbers.add(8);
        numbers.add(1);
        Consumer<Integer> print =  (num) -> System.out.println(num);
        numbers.forEach(print);

        StringFunction inParentheses = (str) -> "("+str+")";

        StringFunction toUpperCase = (str) -> str.toUpperCase(Locale.ROOT);

        printFormatted("Hello",inParentheses);
        printFormatted("Hello",toUpperCase);

    }
}
