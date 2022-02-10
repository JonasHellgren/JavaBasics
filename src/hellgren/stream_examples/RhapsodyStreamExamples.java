package hellgren.stream_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RhapsodyStreamExamples {

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    /***
     *
     The important bit in this conversion is (first, second) -> first), if it is not present there will be error
     java.lang.IllegalStateException: Duplicate key 23 (slightly misleading error, as the duplicated key is 13,
     the value is 23). This is a merge function which resolves collisions between values associated with the same key.
     It evaluates two values found for the same key – first and second where current lambda returns the first.
     If overwrite is needed, hence keep the last entered value then lambda would be: (first, second) -> second)
     */

    public static Map<Long, Long> splitToMap(List<String> stringsList) {
        return stringsList.stream()
                .filter(str -> !str.isEmpty())
                .map(line -> line.split(","))
                .filter(array -> array.length == 2
                        && isNumeric(array[0])
                        && isNumeric(array[1]))
                .collect(Collectors.toMap(array -> Long.valueOf(array[0]),
                        array -> Long.valueOf(array[1]), (first, second) -> first));
        //array -> Long.valueOf(array[1])));  //will raise exception
    }

    public static void main(String[] args) {

        List<String> numList = Arrays.asList("11,21", "12,21", "13,23", "13,24", "13,aa");
        Map<Long, Long> numMap = splitToMap(numList);
        System.out.println("numMap = " + numMap);
    }
}
