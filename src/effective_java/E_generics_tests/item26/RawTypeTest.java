package effective_java.E_generics_tests.item26;

import effective_java.E_generics.item26.RawType;
import org.junit.Assert;
import org.junit.Test;

public class RawTypeTest {

    public static final String STRING_VALUE = "string value ";
    public static final int INT_VALUE = 20;

    @Test
    public  void testNonRaw() {
        RawType<String> genericObj = new RawType<>();
        genericObj.setT(STRING_VALUE);
        System.out.println(" Object created String  type. It's value : " + genericObj.getT());

        Assert.assertEquals(STRING_VALUE, genericObj.getT());
    }

    @Test
    public void testRaw() {
        RawType rawType = new RawType(); // Legal, but it will give warnings.
        rawType.setT(STRING_VALUE);
        System.out.println("Raw Type  Object.  It's value : " + rawType.getT());

        Assert.assertEquals(STRING_VALUE,rawType.getT());

    }

    @Test
    public void testTypeCompileError() {
        RawType<String> genericObj = new RawType<>();
        // genericObj.setT(INT_VALUE);   //does not compile


    }

    @Test
    public void testTypeRunError() {
        RawType rawType = new RawType(); // Legal, but it will give warnings.
        rawType.setT(STRING_VALUE);
        rawType.setT(INT_VALUE);        //compiles and runs despite weird
        System.out.println("Raw Type  Object. It's value : " + rawType.getT());

        Assert.assertEquals(INT_VALUE,rawType.getT());
    }

}
