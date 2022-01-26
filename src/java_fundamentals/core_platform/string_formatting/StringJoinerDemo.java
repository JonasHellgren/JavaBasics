package java_fundamentals.core_platform.string_formatting;

import java.util.StringJoiner;

public class StringJoinerDemo {

    public static void main(String[] args) {

        StringJoiner sj1 = new StringJoiner(", ");
        sj1.add("alpha");
        sj1.add("beta");
        System.out.println("sj2 = " + sj1);

        StringJoiner sj2 = new StringJoiner(", ", "{","}");
        sj2.add("alpha");
        sj2.add("beta");
        System.out.println("sj2 = " + sj2);


    }
}
