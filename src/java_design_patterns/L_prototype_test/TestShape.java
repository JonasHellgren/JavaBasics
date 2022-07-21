package java_design_patterns.L_prototype_test;

import java_design_patterns.L_prototype.shape.Shape;
import java_design_patterns.L_prototype.shape.Square;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {

    @Test
    public void testCloneSquare() {

        Shape square=new Square("123","Square");
        Square squareCopy= (Square) square.clone();

        System.out.println("square = " + square);
        System.out.println("squareCopy = " + squareCopy);

        Assert.assertEquals(square.getId(), squareCopy.getId());


    }

}
