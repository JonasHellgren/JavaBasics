package com.pluralsight.polygoninterface;

public class Rectangle implements Polygon {
    private int h,w;

    // Constructor, initializing sides of a triangle
    Rectangle(int h, int w) {
        this.h = h;  this.w = w;    }

    //define abstract class getSides
    public int[] getSides() {
        int[] sides = new int[4];
        sides[0]=h; sides[1]=h; sides[2]=w; sides[3]=w; return sides;    }

    public double getArea() {   return h*w;  }
}
