package java_design_patterns.D_bridge.draw;

public class DrawerRedCircle implements Drawer {

    public static final String COLOR = "red";


    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: "+ COLOR +", radius: " + radius + ", x: " + x + ", " + y + "]");
    }
}
