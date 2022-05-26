package pluralsight_courses.pluralsight_java_basics.polygoninterface;

public interface Polygon {
    //define abstract methods
    double getArea();  //shall calculate and return area
    int[] getSides();  //shall return array with all sides

    //define default method getPerimeter, sums all sides of polygon
    default int getPerimeter(int... sides) {
        int perimeter=0;
        for (int side:sides) { perimeter += side; }
        return perimeter;
    }
}
