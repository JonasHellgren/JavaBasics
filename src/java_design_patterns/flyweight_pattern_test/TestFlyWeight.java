package java_design_patterns.flyweight_pattern_test;

import java_design_patterns.flyweight_pattern.Circle;
import java_design_patterns.flyweight_pattern.GxfObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestFlyWeight {

    private static final String[] colors = { "Red", "Green", "Blue", "White", "Black" };
    public static final int NOF_RENDERED_OBJECTS = 15;

    @Test
    public void whenManyCirclesFromFactory_thenReused()    {
        GxfObjectFactory factory=new GxfObjectFactory();

        for (int i = 0; i < NOF_RENDERED_OBJECTS; ++i) {
            Circle character = factory.getCharacter(getRandomColor());
            character.setX(getRandomX());
            character.setY(getRandomY());
            character.render();
        }

        System.out.println("factory.getMapSize() = " + factory.getMapSize());

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
