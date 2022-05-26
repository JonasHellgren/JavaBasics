package pluralsight_courses.pluralsight_java_basics.polygoninterface;

class Triangle implements Polygon {
    private int a, b, c;  //the sides of the triangle
    private double s;  //slack variable

    // Constructor, initializing sides of a triangle
    Triangle(int a, int b, int c) {
        this.a = a;  this.b = b;  this.c = c;
        s = 0;   }

    //define abstract class getSides
    public int[] getSides() {
        int[] sides=new int[3];
        sides[0]=a; sides[1]=b; sides[2]=c; return sides; }

    // calculate the area of a triangle, specify abstract method in interface
    public double getArea() {
        s = (double) (a + b + c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        return area;   }
}