package hellgren.lombok;

import lombok.Data;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCatData {

    CatData cat;

    @Before
    public void init() {
        cat=new CatData("Kisse",0.2d,1);
    }

    @Test
    public void testToString() {
        System.out.println("cat = " + cat);
    }

    @Test
    public void testGet() {
        Assert.assertEquals("Kisse",cat.getName());
    }

    @Test
    public void testSet() {
        cat.setName("Donna");
        Assert.assertEquals("Donna",cat.getName());
    }

    @Test
    public void testEquals() {
        CatData cat2=new CatData("Kisse",0.2d,1);
        Assert.assertEquals(cat2, cat);
    }

    @Test
    public void testHash() {
        CatData cat2=new CatData("Kisse",0.2d,1);
        Assert.assertEquals(cat2.hashCode(), cat.hashCode());
    }

    @Test
    public void testNotEqHash() {
        CatData cat2=new CatData("Kisse",0.5d,1);
        Assert.assertNotEquals(cat2.hashCode(), cat.hashCode());
    }

}
