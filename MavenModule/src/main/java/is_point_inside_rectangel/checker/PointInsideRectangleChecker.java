package is_point_inside_rectangel.checker;


import lombok.Builder;
import org.apache.commons.math.util.MathUtils;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/***
 *
 *   This class checks if a point is inside an rectangle, inspired bu
 *   https://martin-thoma.com/how-to-check-if-a-point-is-inside-a-rectangle/
 *
 *   ABCD == ABP+BCP+CDP+DAP with tolerance eps => inside
 *
 *   where
 *  ABCD = 0.5 * abs((yA - yC)*(xD - xB) + (yB - yD)*(xA - xC))
 *
 *  ABP = 0.5 * abs(xA*(yB - yP) + xB*(yP - yA) + xP*(yA - yB))
 *  BCP = 0.5 * abs(xB*(yC - yP) + xC*(yP - yB) + xP*(yB - yC))
 *  CDP = 0.5 * abs(xC*(yD - yP) + xD*(yP - yC) + xP*(yC - yD))
 *  DAP = 0.5 * abs(xD*(yA - yP) + xA*(yP - yD) + xP*(yD - yA))
 *
 *  corners of rectangle are A, B, C, D and point is P
 *
 */
public class PointInsideRectangleChecker {
    private static final double RELATIVE_EPS_DEFAULT = 0.01;
    private static final int NOF_CORNERS_IN_RECTANGLE = 4;
    Function<Double, Double> halfAndThenAbs = a -> 0.5 * Math.abs(a);

    @Builder
    static
    class CornerPoints {
        Point pA;
        Point pB;
        Point pC;
        Point pD;

        public static CornerPoints newFromList(List<Point> corners) {
            if (corners.size()!=NOF_CORNERS_IN_RECTANGLE) {
                throw new IllegalArgumentException("Rectangle does not have 4 corners");
            }
            return CornerPoints.builder()
                    .pA(corners.get(0))
                    .pB(corners.get(1))
                    .pC(corners.get(2))
                    .pD(corners.get(3))
                    .build();
        }
    }

    RotatedRect rect;
    double eps;

    public PointInsideRectangleChecker(RotatedRect rect) {
        this(rect,RELATIVE_EPS_DEFAULT);
    }

    public PointInsideRectangleChecker(RotatedRect rect, double relativeEps) {
        this.rect = rect;
        BiFunction<Double, Double,Double> average = (a,b) -> 0.5*(a+b);
        this.eps=average.apply(rect.size.height,rect.size.width)*relativeEps;
    }

    public boolean isInRectangle(Point point) {
        return MathUtils.equals(area(), areaOfSubRectangles(point), eps);
    }

    public double area() {
        CornerPoints cp = CornerPoints.newFromList(getCornerPoints(rect));
        return halfAndThenAbs.apply((cp.pA.y - cp.pC.y) * (cp.pD.x - cp.pB.x) + (cp.pB.y - cp.pD.y) * (cp.pA.x - cp.pC.x));
    }

    private double areaOfSubRectangles(Point p) {
        CornerPoints cp = CornerPoints.newFromList(getCornerPoints(rect));
        double areaABP = halfAndThenAbs.apply(
                cp.pA.x * (cp.pB.y - p.y) + cp.pB.x * (p.y - cp.pA.y) + p.x * (cp.pA.y - cp.pB.y));
        double areaBCP = halfAndThenAbs.apply(
                cp.pB.x * (cp.pC.y - p.y) + cp.pC.x * (p.y - cp.pB.y) + p.x * (cp.pB.y - cp.pC.y));
        double areaCDP = halfAndThenAbs.apply(
                cp.pC.x * (cp.pD.y - p.y) + cp.pD.x * (p.y - cp.pC.y) + p.x * (cp.pC.y - cp.pD.y));
        double areaDAP = halfAndThenAbs.apply(
                cp.pD.x * (cp.pA.y - p.y) + cp.pA.x * (p.y - cp.pD.y) + p.x * (cp.pD.y - cp.pA.y));
        return areaABP + areaBCP + areaCDP + areaDAP;
    }

    private List<Point> getCornerPoints(RotatedRect rect) {
        Point[] vertices = new Point[NOF_CORNERS_IN_RECTANGLE];
        rect.points(vertices);
        return new ArrayList<>(Arrays.asList(vertices).subList(0, NOF_CORNERS_IN_RECTANGLE));
    }

}
