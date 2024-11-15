package hellgren.lombok;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPersonRecordWith {

    PersonRecordWith person;

    @Before
    public void init() {
        person= PersonRecordWith.builder()
                .firstName("Jonas").lastName("Hellgren")
                .eMail("@gmail").employeer("Volvo").build();
    }

    @Test
    public void whenNotChanged_thenCorrect() {
        Assert.assertEquals("Volvo",person.employeer());
    }

    @Test
    public void whenChangedEmployeer_thenCorrect() {
        PersonRecordWith person2=person.withEmployeer("RISE").withEMail("jonas.hellgren@ri.se");
        Assert.assertEquals("RISE",person2.employeer());
        Assert.assertEquals("jonas.hellgren@ri.se",person2.eMail());
    }


}
