package hellgren.lombok;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCatValue {

    CatValue cat;

    @Before
    public void init() {
        cat=new CatValue("Kisse",0.2d,1);
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
    public void testSetName() {
        //cat.setName("Donna");  //immutable
        Assert.assertEquals("Donna",cat.getName());
    }

    @Test
    public void testStaticFactory() {

       // CatValue cat2=CatValue.of("Kisse",0.2d,1);  //
        Assert.assertEquals("Donna",cat.getName());
    }


    @Test
    public void testSetAge() {
        cat.setAge(2);  //@NonFinal age
        Assert.assertEquals("Donna",cat.getName());
    }

}
