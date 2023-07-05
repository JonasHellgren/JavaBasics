package pluralsight_new_in_java17.adv_java17.records_test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pluralsight_new_in_java17.adv_java17.records.PersonRecord;
import pluralsight_new_in_java17.adv_java17.records.PersonLombok;
import pluralsight_new_in_java17.adv_java17.records.PersonRecordSpecificConstructors;
import pluralsight_new_in_java17.adv_java17.records.PersonRecordWithLastName;

import static org.junit.Assert.*;

public class TestPersonRecord {

    PersonRecord person1, person2;
    PersonRecordSpecificConstructors person;

    @Before
    public void init() {
        String name = "John Doe";
        String address = "100 Linda Ln.";

        person1 = new PersonRecord(name, address);
        person2 = new PersonRecord(name, address);
    }

    @Test
    public void givenSameNameAndAddress_whenEquals_thenPersonsEqual() {
        assertTrue(person1.equals(person2));
    }

    @Test
    public void givenSameNameAndAddress_whenHashCode_thenPersonsEqual() {
        Assert.assertEquals(person1.hashCode(), person2.hashCode());
    }

    @Test(expected = NullPointerException.class)
    public void givenNullName_thenThrows() {
        person = new PersonRecordSpecificConstructors(null,null);
    }

    @Test
    public void givenNewFromName_thenCorrectAddress() {
        person = PersonRecordSpecificConstructors.newFromName("Jonas");
        Assert.assertEquals(PersonRecordSpecificConstructors.NOT_KNOWN_ADDRESS,person.address());
    }

    @Test
    public void givePersonWithLastName_thenCorrectFullName() {
        var person= new PersonRecordWithLastName("Jonas","Hellgren");
        Assert.assertEquals("Jonas Hellgren",person.getFullName());
    }

    @Test
    public void givenPerson_whenCopyWithBuilder_thenEqual() {
        var user = PersonLombok.builder()
                .id(1L)
                .name("Lokesh")
                .email("email@domain.com")
                .status(true)
                .build();

        String newEmail = "newemail@domain.com";
        var sameUserNewEmail=user.copyWithNewEmail(newEmail);

        System.out.println(sameUserNewEmail);

        assertEquals(newEmail,sameUserNewEmail.email());

    }
}
