package hellgren.lombok.delegate;

import org.junit.Assert;
import org.junit.Test;

public class TestPersonDelegater {

    @Test
    public void whenPersonHelper_thenCorrect() {
        Person person=new Person("Jonas",49);
        Assert.assertTrue(person.isAgeOk(person));
        Assert.assertTrue(person.isAdult(person));

    }

}
