package effective_java.E_generics_tests.item29;

import effective_java.E_generics.item29.GenericThing;
import effective_java.E_generics.item29.GenericThingExtendsNumber;
import effective_java.E_generics.item29.ListCreator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class TestThing {

    public static final String STRING_VALUE = "1";
    public static final int INT_VALUE = 1;

    @Test
public void  createIntegerThing()  {
    GenericThing<Integer>  intThing=new GenericThing<>(INT_VALUE);
    System.out.println(intThing.getVal());
    Assert.assertEquals(INT_VALUE, intThing.getVal().intValue());
}


    @Test
    public void  createStringThing()  {
        GenericThing<String>  stringThing=new GenericThing<>(STRING_VALUE);
        System.out.println(stringThing.getVal());
        Assert.assertEquals("1", stringThing.getVal());
    }


    @Test
    public void listCreator() {
        List<Integer> list= ListCreator.listJoiner(1,2);
        System.out.println("list = " + list);
        Assert.assertTrue(list.contains(1));
    }

    @Test
    public void listExtender() {
        List<Integer> list= ListCreator.listJoiner(1,2);
        ListCreator.listExtender(list, 3);

        System.out.println("list = " + list);
        Assert.assertTrue(list.contains(3));
    }

    @Test
    public void testGenericThingExtendsNumber() {
        GenericThingExtendsNumber<Integer>  intThing=new GenericThingExtendsNumber<>(INT_VALUE);
        System.out.println(intThing.getVal());
        Assert.assertEquals(INT_VALUE, intThing.getVal().intValue());
    }

    @Test
    public void testGenericThingExtendsNumberWithString() {
 //       GenericThingExtendsNumber<Integer>  stingThing=new GenericThingExtendsNumber<>(STRING_VALUE);  //does not compile
    }

}
