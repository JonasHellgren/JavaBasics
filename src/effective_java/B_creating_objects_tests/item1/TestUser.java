package effective_java.B_creating_objects_tests.item1;

import effective_java.B_creating_objects.item1.User;
import org.junit.Assert;
import org.junit.Test;

public class TestUser {


    @Test
    public void testCreateUserDefaultType() {

        User user= User.createUserDefaultType("Jonas","Vattugatan 6");
        System.out.println("user = " + user);

        Assert.assertEquals(User.REGULAR,user.getType());

    }

    @Test
    public void testCreateUserEmptyAddress() {

        User user= User.createUserEmptyAddress("Jonas","Engineer");
        System.out.println("user = " + user);

        Assert.assertEquals(User.EMPTY,user.getAddress());

    }

}
