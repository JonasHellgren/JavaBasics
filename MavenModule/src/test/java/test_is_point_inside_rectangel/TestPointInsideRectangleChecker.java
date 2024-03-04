package test_is_point_inside_rectangel;

import hellgren.is_point_inside_rectangel.checker.PointInsideRectangleChecker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

import java.util.Arrays;
import java.util.List;

public class TestPointInsideRectangleChecker {

    private static final double DELTA = 0.1;

    @ParameterizedTest
    @MethodSource("angles")
    public void givenRectangle2by2AnyAngle_thenAreaIs4(Double angle) {
        Point centerPoint= new Point(0,0);
        Size size= new Size(2,2);
        RotatedRect rect=new RotatedRect(centerPoint,size, angle);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        double area= checker.area();
        System.out.println("area = " + area);
        Assertions.assertEquals(4,area, DELTA);
    }

    @ParameterizedTest
    @MethodSource("pointsInside")
    public void givenRectangle2by2Angle0PointInside_thenPointInside (Point pointInside) {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 0);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        Assertions.assertTrue(checker.isInRectangle(pointInside));
    }

    @ParameterizedTest
    @MethodSource("pointsInside")
    public void givenRectangle2by2Angle45PointInside_thenPointInside (Point pointInside) {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 45);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        Assertions.assertTrue(checker.isInRectangle(pointInside));
    }

    @ParameterizedTest
    @MethodSource("pointsOutsideZeroAngle")
    public void givenRectangle2by2Angle0PointOutside_thenPointOutside (Point pointOutside) {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 0);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        Assertions.assertFalse(checker.isInRectangle(pointOutside));
    }

    @ParameterizedTest
    @MethodSource("pointsOutside45Angle")
    public void givenRectangle2by2Angle45PointOutside_thenPointOutside (Point pointOutside) {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 45);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        Assertions.assertFalse(checker.isInRectangle(pointOutside));
    }

    @ParameterizedTest
    @MethodSource("pointsBarelyOutsideZeroAngle")
    public void givenRectangle2by2Angle0PointBarelyOutsideHighTolerance_thenPointInside (Point pointBarelyOutside) {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 0);
        final double relativeEps = 0.5;
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect, relativeEps);
        Assertions.assertTrue(checker.isInRectangle(pointBarelyOutside));
    }

    private static List<Double> angles() {
        return Arrays.asList(0d,10d,45d,90d,180d,250d);
    }

    private static List<Point> pointsInside() {
        return Arrays.asList(new Point(0,0),new Point(1,0),new Point(0.5,0.5),new Point(-1,0));
    }

    private static List<Point> pointsOutsideZeroAngle() {
        return Arrays.asList(new Point(10,0),new Point(-10,0),new Point(5,5),new Point(-1.1,0));
    }

    private static List<Point> pointsOutside45Angle() {
        return Arrays.asList(new Point(10,0),new Point(-5,0),new Point(5,5),new Point(-2.1,0));
    }

    private static List<Point> pointsBarelyOutsideZeroAngle() {
        return Arrays.asList(new Point(1.1,0),new Point(-1.1,0),new Point(1.1,1.1),new Point(1.1,-1.1));
    }

}
