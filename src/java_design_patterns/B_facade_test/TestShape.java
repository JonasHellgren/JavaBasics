package java_design_patterns.B_facade_test;

import java_design_patterns.B_facade.draw_shape.ShapesFacade;
import org.junit.Assert;
import org.junit.Test;

public class TestShape {


    @Test
    public void testNofShapesIsThree() {
        ShapesFacade shapesFacade=new ShapesFacade();
        Assert.assertEquals(3,shapesFacade.nofShapes());
    }


    @Test
    public void testDrawCircle() {
        ShapesFacade shapesFacade=new ShapesFacade();
        shapesFacade.drawCircle();
    }

    @Test
    public void testAll() {
        ShapesFacade shapesFacade=new ShapesFacade();
        shapesFacade.drawAll();
    }

}
