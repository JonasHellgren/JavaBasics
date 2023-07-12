package  pluralsight_new_in_java17.java_tdd.m3;

public class StringUtil {

    public static String truncate(String input, int limit) {

        if (input == null) {
            throw new IllegalArgumentException("String input must not be null");
        }

        if (limit < 1) {
            throw new IllegalArgumentException("Limit input must be greater than 0");
        }

        String ellipsis = "...";
        if (inputTooShort(input, limit, ellipsis)) {
            return input;
        }
        return input.substring(0, limit) + "...";
    }

    private static boolean inputTooShort(String input, int limit, String ellipsis) {
        return input.length() <= limit ||
                input.length() <= ellipsis.length();
    }

    // TODO - Exercise
    public static String truncate(String input, int limit, String cutOffChars) {
        return "";
    }
}
