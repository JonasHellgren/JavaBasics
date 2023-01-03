package effective_java.E_generics_tests.generic_interface;

import effective_java.E_generics.generic_interface.*;
import org.junit.Assert;
import org.junit.Test;

public class FruitTest {

    private static final double DELTA = 0.1;

    @Test
    public void orange() {
        OrangeProperties op=new OrangeProperties();
        op.diameter=7;
        FruitInterface<OrangeProperties> orange=new Orange(op);
        orange.showProperties();

        Assert.assertEquals(7, orange.getProperties().diameter, DELTA);
    }

    @Test public void banana() {
        BananaProperties bp=new BananaProperties();
        bp.length=12;
        FruitInterface<BananaProperties> banana=new Banana(bp);
        banana.showProperties();

        Assert.assertEquals(12, banana.getProperties().length, DELTA);
    }
}
