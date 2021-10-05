package packt_Java_coding_problems;

import lombok.Getter;
import lombok.ToString;
import org.junit.Assert;
import org.junit.Test;


public class TestCloneable {

    @Test
    public void TestClone ()  {
        Point point=new Point(1,1);
        Point clone=point.clone();

        System.out.println(point);
        System.out.println(clone);

        Assert.assertEquals(point.getX(),clone.getX(),0.1);
        Assert.assertEquals(point.getY(),clone.getY(),0.1);

    }




}
