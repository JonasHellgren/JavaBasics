package effective_java.creating_objects_tests;

import effective_java.creating_objects.Circle;
import effective_java.creating_objects.Rectangle;
import effective_java.creating_objects.Shape;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {

    @Test
    public void TestRectangle() {
        Shape rectangle= Shape.createRectangle(10,10);
        System.out.println("rectangle = " + rectangle);
        Assert.assertTrue(rectangle instanceof Rectangle);
    }

    @Test
    public void TestCircle() {
        Shape circle= Shape.createCircle(10);
        System.out.println("circle = " + circle);
        Assert.assertTrue(circle instanceof Circle);
    }

}
