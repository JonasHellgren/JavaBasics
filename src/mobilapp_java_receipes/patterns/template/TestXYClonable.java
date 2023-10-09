package mobilapp_java_receipes.patterns.template;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class TestXYClonable {

    @SneakyThrows
    @Test
    public void whenClone_thenEqual() {

        XYClonable  xy=new XYClonable(1,2);
        XYClonable xyClone=xy.clone();

        printing(xy, xyClone);

        assertEquals(xyClone.x,xy.x);
        assertEquals(xyClone.y,xy.y);
    }



    @SneakyThrows
    @Test
    public void whenCloneAndChange_thenNotEqual() {

        XYClonable  xy=new XYClonable(1,2);
        XYClonable xyClone=xy.clone();
        xy.x=10;
        xy.y=11;

        printing(xy, xyClone);

        assertNotEquals(xyClone.x,xy.x);
        assertNotEquals(xyClone.y,xy.y);

    }

    private static void printing(XYClonable xy, XYClonable xyClone) {
        System.out.println("xy = " + xy);
        System.out.println("xyClone = " + xyClone);
    }

}
