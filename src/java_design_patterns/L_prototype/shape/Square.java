package java_design_patterns.L_prototype.shape;

public class Square extends Shape {

    public Square(String id, String type) {
        super(id, type);
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
