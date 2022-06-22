package effective_java.B_creating_objects_tests.item1;

import effective_java.B_creating_objects.item1.ColorWithoutDuplicates;
import org.junit.Assert;
import org.junit.Test;

public class TestColorWithoutDuplicates {

    @Test
    public void twoRedsGivesOneInCache() {
        ColorWithoutDuplicates tomato = ColorWithoutDuplicates.makeFromPalette(255, 99, 71);
        ColorWithoutDuplicates red = ColorWithoutDuplicates.makeFromPalette(255, 99, 71);
        Assert.assertEquals(1,ColorWithoutDuplicates.sizeOfCache());
        Assert.assertEquals(tomato,red);
    }

    @Test
    public void redGreenBlueGivesThreeInCache() {
        ColorWithoutDuplicates red = ColorWithoutDuplicates.makeFromPalette(255, 99, 71);
        ColorWithoutDuplicates green = ColorWithoutDuplicates.makeFromPalette(99, 255, 71);
        ColorWithoutDuplicates blue = ColorWithoutDuplicates.makeFromPalette(71,99, 255);
        Assert.assertEquals(3,ColorWithoutDuplicates.sizeOfCache());
    }

}
