package guava;


import com.google.common.collect.Range;

public class TestRange {

    public static void main(String[] args) {
        Range<Integer> validGrades = Range.closed(1, 100);

        System.out.println(validGrades.contains(70)); // true
        System.out.println(validGrades.contains(0));  // false

        Range<Double> validSpeeds = Range.closed(0d, 50d);
        System.out.println("validSpeeds.contains(20d) = " + validSpeeds.contains(20d));

        System.out.println("validGrades.encloses(validGrades) = " + validGrades.encloses(validGrades));

        System.out.println("validSpeeds.lowerEndpoint() = " + validSpeeds.lowerEndpoint());
        System.out.println("validSpeeds.upperEndpoint() = " + validSpeeds.upperEndpoint());
    }
}
