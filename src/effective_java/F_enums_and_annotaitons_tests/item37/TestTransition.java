package effective_java.F_enums_and_annotaitons_tests.item37;

import effective_java.F_enums_and_annotaitons.item37.Phase;
import org.junit.Assert;
import org.junit.Test;

public class TestTransition {

    @Test
    public void testTransMelt() {

        Phase.Transition transition=Phase.from(Phase.SOLID,Phase.LIQUID);
        System.out.println("transition = " + transition);

        Assert.assertEquals(Phase.Transition.MELT,transition);

    }

}
