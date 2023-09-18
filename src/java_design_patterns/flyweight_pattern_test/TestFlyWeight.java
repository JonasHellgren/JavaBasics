package java_design_patterns.flyweight_pattern_test;

import java_design_patterns.flyweight_pattern.Circle;
import java_design_patterns.flyweight_pattern.GfxObject;
import java_design_patterns.flyweight_pattern.GxfObjectFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * A common practice is to keep state in external data structures and pass them to the Flyweight Object when needed.
 * Each Flyweight Object is divided into two pieces: the state-dependent (extrinsic) part, and the state-independent
 * (intrinsic) part. Intrinsic can be saved in map.
 * intrinsic=color, extrinsic=position
 *
 *
 */

public class TestFlyWeight {

    private static final String[] colors = { "Red", "Green", "Blue", "White", "Black" };
    public static final int NOF_RENDERED_OBJECTS = 15;

    @Test
    public void whenManyCirclesFromFactory_thenReused()    {
        GxfObjectFactory factory=new GxfObjectFactory();

        for (int i = 0; i < NOF_RENDERED_OBJECTS; ++i) {
            Circle gfxObject = (Circle) factory.getGfxObject(getRandomColor());
            gfxObject.setX(getRandomX());
            gfxObject.setY(getRandomY());
            gfxObject.render();
        }

        Assert.assertTrue(factory.getMapSize() < NOF_RENDERED_OBJECTS );

    }

    private static String getRandomColor() {
        return colors[(int)(Math.random() * colors.length)];
    }
    private static int getRandomX() {
        return (int)(Math.random() * 100);
    }
    private static int getRandomY() {
        return (int)(Math.random() * 100);
    }

}
