package hellgren.test_private_methods;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;
import java.lang.reflect.Method;

/**
 * https://www.youtube.com/watch?v=HjvEkexsrWk
 */

public class TestPrivateSum {

    @SneakyThrows
    @Test
    public void whenSumming2and2_thenResultIs4() {
        Method method= ClassWithPrivateMethod.class.getDeclaredMethod("sum",Integer.class,Integer.class);
        method.setAccessible(true);
        ClassWithPrivateMethod classWithPrivateMethod=new ClassWithPrivateMethod();
        int sum= (int) method.invoke(classWithPrivateMethod,2,2);
        Assert.assertEquals(4,sum);
    }
}
