package effective_java.F_enums_and_annotaitons_tests.item35;

import effective_java.F_enums_and_annotaitons.item35.Ensamble;
import org.junit.Assert;
import org.junit.Test;

public class TestEnsamble {

    @Test
    public void test() {

        System.out.println(Ensamble.SOLO+" has "+Ensamble.SOLO.getNofMusicians()+" musicians");

        Assert.assertEquals(1,Ensamble.SOLO.getNofMusicians());

    }

}
