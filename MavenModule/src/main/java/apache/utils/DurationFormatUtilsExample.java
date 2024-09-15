package apache.utils;


import org.apache.commons.lang.time.DurationFormatUtils;

public class DurationFormatUtilsExample {
    public static void main(String[] args) {
        long durationMillis = 120000; // 2 minutes in milliseconds

        // Format duration in H:m:s.S format
        String formattedDuration = DurationFormatUtils.formatDuration(durationMillis, "H:mm:ss.S");
        System.out.println(formattedDuration);

        // Format duration in words
        String formattedDurationWords = DurationFormatUtils.formatDurationWords(durationMillis, true, true);
        System.out.println(formattedDurationWords);
    }
}
