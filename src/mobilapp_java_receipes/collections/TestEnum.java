package mobilapp_java_receipes.collections;

import org.junit.Assert;
import org.junit.Test;

public class TestEnum {

    enum Season {
        Summer, Fall, Winter, Spring
    }

    enum Size {
        Small("S"), Middle("M"), Large("L");
        private final String sizeName;

        Size(String name) {
            this.sizeName = name;
        }

        public String getSizeName() {
            return sizeName;
        }
    }


    @Test
    public void whenSeasonCorrectPos() {
        var winter = Season.Winter;
        Assert.assertEquals(2,winter.ordinal());
    }

    @Test
    public void whenSeasonCorrectValue() {
        var seasons = Season.values();
        Assert.assertEquals(4,seasons.length);
    }

    @Test
    public void whenSizeCorrectName() {
        Size size=Size.Large;
        Assert.assertEquals("L",size.getSizeName());
    }

}
