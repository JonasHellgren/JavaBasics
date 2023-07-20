package pluralsight_new_in_java17.adv_java17.records_test;


import org.junit.Assert;
import org.junit.Test;
import pluralsight_new_in_java17.adv_java17.records.PersonRecordDefaultValues;

public class PersonRecordDefaultValuesTest {

    @Test
    public void whenNameAndAddress_thenCorrect() {

        String name = "Jonas";
        String address = "Vattugatan 6";
        PersonRecordDefaultValues person= PersonRecordDefaultValues.builder()
                .name(name).address(address)
                .build();

        System.out.println("person = " + person);

        Assert.assertEquals(name,person.name());
        Assert.assertEquals(address,person.address());

    }

    @Test
    public void whenOnlyAddress_thenCorrect() {

        String address = "Vattugatan 6";
        PersonRecordDefaultValues person= PersonRecordDefaultValues.builder()
                .address(address)
                .build();

        System.out.println("person = " + person);

        Assert.assertEquals(PersonRecordDefaultValues.DEFAULT_NAME,person.name());
        Assert.assertEquals(address,person.address());

    }

    @Test
    public void whenOnlyName_thenCorrect() {

        String name = "Jonas";
        PersonRecordDefaultValues person= PersonRecordDefaultValues.builder()
                .name(name)
                .build();

        System.out.println("person = " + person);

        Assert.assertEquals(PersonRecordDefaultValues.DEFAULT_AGE,person.age());
        Assert.assertEquals(name,person.name());

    }

}