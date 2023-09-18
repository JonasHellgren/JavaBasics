package java_design_patterns.flyweight_pattern;

public class Circle implements GfxObject{

    private String color;
    private int x;
    private int y;

    public Circle(String color){
        this.color = color;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void render() {
        System.out.println("Character at position " + x + ", " + y + " with color " + color);
    }
}
