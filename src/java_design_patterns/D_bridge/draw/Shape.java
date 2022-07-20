package java_design_patterns.D_bridge.draw;

public abstract class Shape {
    protected Drawer drawer;

    protected Shape(Drawer drawer){
        this.drawer = drawer;
    }
    public abstract void draw();
}
