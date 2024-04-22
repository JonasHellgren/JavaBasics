package apache.runners;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

public class StringExamples {
    public static void main(String[] args) {
        String str = " Hello World ";

        // Checking if a string is empty or all whitespace
        System.out.println("Is it empty? " + StringUtils.isEmpty(str)); // false
        System.out.println("Is it blank? " + StringUtils.isBlank(str)); // false, whitespace counts here!

        // Trimming, reversing, and abbreviating strings
        System.out.println("Trimmed: " + StringUtils.trim(str)); // "Hello World"
        System.out.println("Reversed: " + StringUtils.reverse(str)); // " dlroW olleH "
        System.out.println("Short version: " + StringUtils.abbreviate(str, 10)); // " Hello W..."

        int same= StringUtils.compareIgnoreCase("Jonas","jonas");
        System.out.println("same = " + same);


        int notSame= StringUtils.compareIgnoreCase("Jonas","jona");
        System.out.println("notSame = " + notSame);

        // Generating random alphanumeric strings
        System.out.println("Random Alphanumeric: " + RandomStringUtils.randomAlphanumeric(10));

        // Just numbers
        System.out.println("Random Numeric: " + RandomStringUtils.randomNumeric(5));

        String strNull = null;
        // No more NullPointerExceptions!
        System.out.println("Default String: " + ObjectUtils.defaultIfNull(strNull, "defaultString"));

        // Easily find the first non-null object
        String firstNonNull = ObjectUtils.firstNonNull(null, null, "firstNonNull", "second");
        System.out.println("First non-null: " + firstNonNull);

    }
}