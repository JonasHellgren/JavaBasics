package effective_java.creating_objects;

public interface Shape {

    static Shape createRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

    static Shape createCircle(int radius)  {
        return new Circle(radius);
    }
}
