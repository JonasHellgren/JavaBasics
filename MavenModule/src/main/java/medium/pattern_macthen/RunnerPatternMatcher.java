package medium.pattern_macthen;

/***
 * https://medium.com/@vikas.taank_40391/advanced-java-features-you-must-know-00c4ed02c872
 */

public class RunnerPatternMatcher {

    // A simple Point class
    static final class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point(" + x + ", " + y + ")";
        }
    }

    public static void main(String[] args) {
        Object obj = new Point(3, 4);

        // Use pattern matching in switch to handle different types
        String result = switch (obj) {
            case null -> "The object is null";
            case String s -> "It's a string: " + s.toUpperCase();
            case Integer i -> "It's an integer: " + (i * i);
            case Point p -> "It's a point: " + p;
            default -> "Unknown type";
        };

        System.out.println(result);
    }

}
