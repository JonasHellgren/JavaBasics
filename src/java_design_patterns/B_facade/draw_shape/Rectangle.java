package java_design_patterns.B_facade.draw_shape;

public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}

