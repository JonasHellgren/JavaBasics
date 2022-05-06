package hellgren.lombok;

import lombok.ToString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestCatGetterSetter {

    CatGetterSetter cat;

    @Before
    public void init() {

        //@RequiredArgsConstructor => request final and NonNull fields

        cat=new CatGetterSetter("Kisse",0.2d,1);
    }

    @Test
    public void testToString() {
        //@ToString(includeFieldNames = false) => no field names
        //@ToString.Exclude => no age printed
        System.out.println("cat = " + cat);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Kisse",cat.getName());
    }

    @Test
    //getWeight disabled by @Getter(AccessLevel.NONE)
    public void testGetWeight() {
       // Assert.assertEquals("Kisse",cat.getWeight());
    }

    @Test
    //setAge disabled by @Getter(AccessLevel.NONE)
    public void testSetAge() {
     //   cat.setAge(2);
    }

}
