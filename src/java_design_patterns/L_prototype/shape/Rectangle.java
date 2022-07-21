package java_design_patterns.L_prototype.shape;

import lombok.AllArgsConstructor;


public class Rectangle extends Shape {

    public Rectangle(String id, String type) {
        super(id, type);
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
