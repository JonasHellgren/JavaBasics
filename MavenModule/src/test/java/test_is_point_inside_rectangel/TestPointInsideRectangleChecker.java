package test_is_point_inside_rectangel;

import is_point_inside_rectangel.checker.PointInsideRectangleChecker;
import org.junit.Assert;
import org.junit.Test;
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

    @Test public void givenRectangle2by2Angle0PointAtOrigo_thenSubAreaIs1 () {
        RotatedRect rect=new RotatedRect(new Point(0,0),new Size(2,2), 0);
        PointInsideRectangleChecker checker=new PointInsideRectangleChecker(rect);
        double area=checker.areaOfSubRectangles(new Point(10.0,1.0));
        System.out.println("area = " + area);
    }


    private static List<Double> angles() {
        return Arrays.asList(0d,10d,45d,90d,180d,250d);
    }

}
