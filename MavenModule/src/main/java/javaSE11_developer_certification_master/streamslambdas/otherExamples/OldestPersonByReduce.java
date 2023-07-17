package javaSE11_developer_certification_master.streamslambdas.otherExamples;
import javaSE11_developer_certification_master.streamslambdas.otherExamples.models.Person;



import java.util.Arrays;
import java.util.List;


public class OldestPersonByReduce {

    public static void main(String[] args) {

        List<Person> persons = Arrays.asList(new Person("Jonas", 47), new Person("Alex", 3));

        //We can use custom objects that contain non-primitive fields. To do so, we need to provide a relevant
        // identity, accumulator and combiner for the data type.


        Person oldest = persons.stream().
                reduce(
                        new Person("new born",0),  //identity
                       (partRes, person) -> Person.oldest(partRes,person),  //accumulator
                        Person::oldest);  //combiner

        System.out.println("oldest = " + oldest);

    }

}
