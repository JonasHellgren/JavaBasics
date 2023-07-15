package hellgren.debugging;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/***
 * By using debugging one can realize, for checkPerson1, that p==person is false when person.name is Jonas
 * Breakpoint with stop condition person.name.equals("Jonas")
 */

public class ListOfPersonForDebug {

    record Person(String name, int age) {}

    List<Person> personList=List.of(new Person("Jonas",49),new Person("Christofer",20));

    @Test
    public void whenWrongCheck_thenNotInList() {
        boolean isInList1=checkPerson1(personList,new Person("Jonas",49));
        Assert.assertFalse(isInList1);
    }

    private static boolean checkPerson1(List<Person> personList, Person person) {
        for (Person p:personList) {
            if (p==person) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void whenCorrectCheck_thenInList() {
        boolean isInList1=checkPerson2(personList,new Person("Jonas",49));
        Assert.assertTrue(isInList1);
    }

    private static boolean checkPerson2(List<Person> personList, Person person) {
        for (Person p:personList) {
            if (p.equals(person)) {
                return true;
            }
        }
        return false;
    }


}
