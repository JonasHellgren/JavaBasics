package pluralsight_new_in_java17.playbook;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

import static org.junit.Assert.assertEquals;

public class TestSort {

    List<Double> doubleList = new ArrayList<>(List.of(1.1234, 2.345));

    record Person(String name, Integer age) {};

    List<Person> personList=List.of(
            new Person("Jonas", 49), new Person("Alex",4), new Person("Christofer",20)
    );

    List<Person> personListMutable=new ArrayList<>(personList);

    @Test
    public void whenSortedNatural_thenCorrect() {
        doubleList.sort(Comparator.naturalOrder());
        assertEquals(new ArrayList<>(List.of(1.1234, 2.345)), doubleList);
    }

    @Test
    public void whenSortedReverse_thenCorrect() {
        doubleList.sort(Comparator.reverseOrder());
        assertEquals(new ArrayList<>(List.of(2.345,1.1234)), doubleList);
    }

    @Test
    public void whenPersonSortedByAge_thenCorrect() {
        personListMutable.sort(Comparator.comparing(Person::age));  //youngest first
        assertEquals(personList.get(1), personListMutable.get(0));
    }

    @Test
    public void whenPersonSortedByAgeAndReversed_thenCorrect() {
        personListMutable.sort(Comparator.comparing(Person::age).reversed());  //oldest first
        assertEquals(personList.get(0), personListMutable.get(0));
    }



}
