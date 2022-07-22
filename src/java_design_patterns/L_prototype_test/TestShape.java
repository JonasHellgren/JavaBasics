package java_design_patterns.L_prototype_test;

import java_design_patterns.L_prototype.shape.Shape;
import java_design_patterns.L_prototype.shape.Square;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {

    @Test
    public void testCloneSquare() {
        Shape square=new Square("123","Square");
        Shape squareCopy= square.clone();

        Assert.assertTrue(squareCopy instanceof Square);
        Assert.assertTrue(squareCopy.equals(square));
    }

}
