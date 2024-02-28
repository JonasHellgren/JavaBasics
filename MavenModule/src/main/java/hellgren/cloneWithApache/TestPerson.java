package hellgren.cloneWithApache;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void whenCloned_thenCorrect() {

        Person orig=new Person("Alex",5);
        var clone=orig.clone();
        orig.setAge(6);

        System.out.println("orig = " + orig);
        System.out.println("clone = " + clone);

        Assert.assertNotEquals(orig.getAge(),clone.getAge());
        Assert.assertNotEquals(orig,clone);

    }
}
