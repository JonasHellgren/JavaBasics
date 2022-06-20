package effective_java.creating_objects_tests;

import effective_java.creating_objects.ColorWithoutDuplicates;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

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
