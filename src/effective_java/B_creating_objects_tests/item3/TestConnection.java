package effective_java.B_creating_objects_tests.item3;

import effective_java.B_creating_objects.item3.ConnectionSingleton;
import org.junit.Assert;
import org.junit.Test;

public class TestConnection {

    @Test
    public void twoSingletonsSameReferences() {
        ConnectionSingleton connection1= ConnectionSingleton.getSingletonInstance("Aftonbladet", "www.aftonbladet.se");
        ConnectionSingleton connection2= ConnectionSingleton.getSingletonInstance("Aftonbladet", "www.aftonbladet.se");

        System.out.println("connection1 = " + connection1);
        Assert.assertEquals(connection1,connection2);
    }

    @Test
    public void twoNonSingletonsDifferentReferences() {
        ConnectionSingleton connection1=new ConnectionSingleton("Aftonbladet", "www.aftonbladet.se");
        ConnectionSingleton connection2=new ConnectionSingleton("Aftonbladet", "www.aftonbladet.se");

        System.out.println("connection1 = " + connection1);
        Assert.assertNotEquals(connection1,connection2);
    }
}
