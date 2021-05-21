package com.pluralsight.polygoninterface;

public class Main {
    public static void main(String[] args) {
        //create object t1 and r1
        Triangle t1 = new Triangle(2, 3, 4);
        Rectangle r1 = new Rectangle(2, 3);
        double area, perim;  //variables set later in code for both classes

        // calls the method of the Triangle class
        area=t1.getArea();  System.out.println("Triangle Area: " + area);

        // calls the default method of Polygon
        perim=t1.getPerimeter(t1.getSides());  System.out.println("Triangle Perimeter: " + perim);

        // calls the method of the Rectangle class
        area=r1.getArea(); System.out.println("Rectangle Area: " + area);

        // calls the default method of Polygon
        perim=r1.getPerimeter(r1.getSides());  System.out.println("Rectangle Perimeter: " + perim);
    }
}
