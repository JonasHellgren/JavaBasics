package ps_new_in_java17_junit5.junit5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/***
 * Filtering on tag fails if importing org.junit.Test
 *
 */

public class TagAnnotationTest {

    @Test
    @Tag("bool")
    public void testTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    @Tag("bool")
    public void testFalse() {
        Assertions.assertFalse(false);
    }

    @Test
    @Tag("math")
    public void testOnePlusOne() {
        Assertions.assertEquals(2,1+1);
    }

    @Tag("math")
    @Test
    public void testOnePlusTwo() {
        Assertions.assertEquals(3,1+2);
    }


}
