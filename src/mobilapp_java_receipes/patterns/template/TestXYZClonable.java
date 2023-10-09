package mobilapp_java_receipes.patterns.template;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

public class TestXYZClonable {

    @SneakyThrows
    @Test
    public void whenClone_thenEqual() {

        XYZClonable  xyz=new XYZClonable(new XYClonable(1,2),3);
        XYZClonable xyzClone=xyz.clone();

        printing(xyz, xyzClone);

        Assert.assertEquals(xyzClone.z,xyz.z);
        Assert.assertEquals(xyzClone.xy.x,xyz.xy.x);
        Assert.assertEquals(xyzClone.xy.y,xyz.xy.y);

    }


    @SneakyThrows
    @Test
    public void whenCloneAndChange_thenNotEqual() {

        XYZClonable  xyz=new XYZClonable(new XYClonable(1,2),3);
        XYZClonable xyzClone=xyz.clone();
        xyzClone.z=10;
        xyzClone.xy.x=10;
        xyzClone.xy.y=10;

        printing(xyz, xyzClone);

        Assert.assertNotEquals(xyzClone.z,xyz.z);
        Assert.assertNotEquals(xyzClone.xy.x,xyz.xy.x);
        Assert.assertNotEquals(xyzClone.xy.y,xyz.xy.y);

    }

    private static void printing(XYZClonable xyz, XYZClonable xyzClone) {
        System.out.println("xyz = " + xyz);
        System.out.println("xyzClone = " + xyzClone);
    }


}
