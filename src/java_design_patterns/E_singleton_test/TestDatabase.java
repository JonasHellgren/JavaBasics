package java_design_patterns.E_singleton_test;

import java_design_patterns.E_singleton.Database;
import org.junit.Assert;
import org.junit.Test;

public class TestDatabase {

    @Test
    public void test() {

        Database db1= Database.getInstance();
        db1.getConnection();
        Database db2= Database.getInstance();  //will return same instance

        Assert.assertEquals(db1,db2);  //same memory reference
    }
}
