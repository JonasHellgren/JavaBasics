package java_design_patterns.D_bridge_test;

import java_design_patterns.D_bridge.draw.Circle;
import java_design_patterns.D_bridge.draw.DrawerGreenCircle;
import java_design_patterns.D_bridge.draw.DrawerRedCircle;
import java_design_patterns.D_bridge.draw.Shape;
import org.junit.Test;

public class TestDrawer {

    @Test
    public void test() {
        Shape redCircle = new Circle(100,100, 10, new DrawerRedCircle());
        Shape greenCircle = new Circle(100,100, 10, new DrawerGreenCircle());

        redCircle.draw();
        greenCircle.draw();

    }
}
