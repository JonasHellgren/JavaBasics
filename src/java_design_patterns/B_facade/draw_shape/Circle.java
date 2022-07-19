package java_design_patterns.B_facade.draw_shape;

public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
