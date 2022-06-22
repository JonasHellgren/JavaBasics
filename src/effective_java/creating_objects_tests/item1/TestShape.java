package effective_java.creating_objects_tests.item1;

import effective_java.creating_objects.item1.Circle;
import effective_java.creating_objects.item1.Rectangle;
import effective_java.creating_objects.item1.Shape;
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
