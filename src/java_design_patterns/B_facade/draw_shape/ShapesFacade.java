package java_design_patterns.B_facade.draw_shape;

import java.util.ArrayList;
import java.util.List;

public class ShapesFacade {
    private final Shape circle;
    private final Shape rectangle;
    private final Shape square;
    List<Shape> shapes;

    public ShapesFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();

        shapes=new ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);
        shapes.add(square);
    }

    public void drawCircle(){
        circle.draw();
    }
    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }

    public void drawAll() {
        shapes.forEach(Shape::draw);
    }

    public int nofShapes() {
        return shapes.size();
    }
}
