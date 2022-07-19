package java_design_patterns.B_facade.draw_shape;

public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square::draw()");
    }
}
