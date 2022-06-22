package effective_java.C_methods_common_to_all_objects_tests.item10;

import effective_java.C_methods_common_to_all_objects.item10.PairWithEqual;
import org.junit.Assert;
import org.junit.Test;

public class TestPairWithEqual {

    @Test
    public void testEquals() {
        PairWithEqual p1=new  PairWithEqual("a", 2);
        PairWithEqual p2=new  PairWithEqual("a", 2);

        Assert.assertTrue(p1.equals(p2));
    }

    @Test
    public void testNotEquals() {
        PairWithEqual p1=new  PairWithEqual("a", 2);
        PairWithEqual p2=new  PairWithEqual("a", 23);

        Assert.assertFalse(p1.equals(p2));
    }

}
