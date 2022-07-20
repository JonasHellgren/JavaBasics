package java_design_patterns.D_bridge.draw;

public class Circle extends Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius, Drawer drawer) {
        super(drawer);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawer.drawCircle(radius,x,y);
    }
}
