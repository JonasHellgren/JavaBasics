package test_is_point_inside_rectangel;


import org.bytedeco.opencv.opencv_core.Point2f;
import org.junit.Assert;
import org.junit.Test;


import org.opencv.core.Point;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TestModels {


    private static final double DELTA = 0.1;

    @Test
    public void givenPointXis1Yis2_thenIsPoint() {
        Point point2D= new Point(1,2);
        System.out.println("point2D = " + point2D);
        Assert.assertEquals(1,point2D.x, DELTA);
        Assert.assertEquals(2,point2D.y,DELTA);
    }

    @Test public void givenRectangleAtOrigoWithSize2_thenRectangleHasMinus1Minus1Corner() {
        Point centerPoint= new Point(0,0);
        Size size= new Size(2,2);
        final double angle = 0;
        RotatedRect rotatedRect=new RotatedRect(centerPoint,size, angle);
        List<Point> pointList = getCornerPoints(rotatedRect);
        System.out.println("pointList = " + pointList);
        Assert.assertTrue(pointList.contains(new Point(-1d,-1d)));
    }

    private List<Point>  getCornerPoints(RotatedRect rotatedRect) {
        Point[] vertices=new Point[4];
        rotatedRect.points(vertices);
        return  new ArrayList<>(Arrays.asList(vertices).subList(0, 4));
    }

}
