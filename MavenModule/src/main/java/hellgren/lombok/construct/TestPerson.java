package hellgren.lombok.construct;

import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void givenPerson_whenCorrect() {
        String firstName = "Jonas";
        String lastName = "Hellgren";
        var person1 = Person.create(firstName, lastName);
        var person2 = Person.createFromPersonName(PersonName.of(firstName, lastName));
        Assert.assertEquals(firstName, person1.getName().getFirstName());
        Assert.assertEquals(firstName, person2.getName().getFirstName());
    }

    @Test
    public void givenUtils_thenCorrect() {

        //var util = new Util();  //private constructor
        Assert.assertEquals(3, Util.add(1, 2));

    }

}
