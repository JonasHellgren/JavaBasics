package java_fundamentals.core_platform.string_formatting;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class FormattingExample {

    public static void main(String[] args) {

        int     david = 13, dawson = 11, dillon = 4, gordon = 2;
        List<Integer> intList= Arrays.asList(13,4,5,7);

        IntSummaryStatistics stats = intList.stream().
                mapToInt(Integer::intValue).
                summaryStatistics();

        String text=String.format("Average is %.1f years",stats.getAverage());

        System.out.println("text = " + text);

    }
}
