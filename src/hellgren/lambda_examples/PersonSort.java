package hellgren.lambda_examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PersonSort {

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    static
    class Person {
        private String name;
        private int age;
    }

    public static void main(String[] args) {
        List<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(new Person("abc", 27));
        listOfPerson.add(new Person("mno", 26));
        listOfPerson.add(new Person("pqr", 28));
        listOfPerson.add(new Person("xyz", 27));

        Comparator<Person> ageComparator1= (p1,p2) -> p1.getAge()-p2.getAge();  //a-b=neg <=> a<b
        Comparator<Person> ageComparator2= Comparator.comparingInt(Person::getAge);  //a-b=neg <=> a<b
        Collections.sort(listOfPerson,ageComparator1);
        System.out.println("listOfPerson = " + listOfPerson);
        List<Person> sortedListOfPerson=listOfPerson.stream().sorted(ageComparator2.reversed()).collect(Collectors.toList());
        System.out.println("sortedListOfPerson = " + sortedListOfPerson);

    }


}
