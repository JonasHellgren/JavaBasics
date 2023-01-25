package is_point_inside_rectangel.checker;


import lombok.AllArgsConstructor;
import lombok.Builder;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.RotatedRect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/***
 *
 * https://martin-thoma.com/how-to-check-if-a-point-is-inside-a-rectangle/
 */
public class PointInsideRectangleChecker {

    @Builder
    static
    class CornerPoints {
        Point pA;
        Point pB;
        Point pC;
        Point pD;

        public static CornerPoints newFromList(List<Point> corners) {
            return CornerPoints.builder()
                    .pA(corners.get(0))
                    .pB(corners.get(1))
                    .pC(corners.get(2))
                    .pD(corners.get(3))
                    .build();
        }
    }

    RotatedRect rect;

    public PointInsideRectangleChecker(RotatedRect rect) {
        this.rect = rect;
    }

    public double area() {
        List<Point> corners=getCornerPoints(rect);
        Point pA=corners.get(0);
        Point pB=corners.get(1);
        Point pC=corners.get(2);
        Point pD=corners.get(3);
        //ABCD = 0.5 * abs((yA - yC)*(xD - xB) + (yB - yD)*(xA - xC))
        return 0.5*(Math.abs(
                (pA.y-pC.y)*(pD.x- pB.x)+(pB.y-pD.y)*(pA.x- pC.x)
        ));
    }

    public double areaOfSubRectangles(Point p)  {

        CornerPoints cp=CornerPoints.newFromList(getCornerPoints(rect));

        /**
         *         ABP = 0.5 * abs(xA*(yB - yP) + xB*(yP - yA) + xP*(yA - yB))
         *         BCP = 0.5 * abs(xB*(yC - yP) + xC*(yP - yB) + xP*(yB - yC))
         *         CDP = 0.5 * abs(xC*(yD - yP) + xD*(yP - yC) + xP*(yC - yD))
         *         DAP = 0.5 * abs(xD*(yA - yP) + xA*(yP - yD) + xP*(yD - yA))
         */

        Function<Double,Double> halfAndThenAbs= a -> 0.5*Math.abs(a);

        double areaABP=halfAndThenAbs.apply(
                cp.pA.x*(cp.pB.y- p.y)+cp.pB.x*(p.y- cp.pA.y)+p.x*(cp.pA.y- cp.pB.y));
        double areaBCP=halfAndThenAbs.apply(
                cp.pB.x*(cp.pC.y- p.y)+cp.pC.x*(p.y- cp.pB.y)+p.x*(cp.pB.y- cp.pC.y));
        double areaCDP=halfAndThenAbs.apply(
                cp.pC.x*(cp.pD.y- p.y)+cp.pD.x*(p.y- cp.pC.y)+p.x*(cp.pC.y- cp.pD.y));
        double areaDAP=halfAndThenAbs.apply(
                cp.pD.x*(cp.pA.y- p.y)+cp.pA.x*(p.y- cp.pD.y)+p.x*(cp.pD.y- cp.pA.y));

        System.out.println("areaABP = " + areaABP);
        System.out.println("areaBCP = " + areaBCP);
        System.out.println("areaCDP = " + areaCDP);
        System.out.println("areaDAP = " + areaDAP);

        return areaABP+areaBCP+areaCDP+areaDAP;
    }

    private List<Point> getCornerPoints(RotatedRect rect) {
        Point[] vertices=new Point[4];
        rect.points(vertices);
        return  new ArrayList<>(Arrays.asList(vertices).subList(0, 4));
    }

}
