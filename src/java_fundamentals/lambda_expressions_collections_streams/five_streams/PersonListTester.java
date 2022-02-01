package java_fundamentals.lambda_expressions_collections_streams.five_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonListTester {

    public static void main(String[] args) {

        List<Person> persons=new ArrayList<>();
        persons.add(new Person("Jonas",47));
        persons.add(new Person("Alex",3));
        persons.add(new Person("Katja",48));
        persons.add(new Person("Christofer",19));

        boolean isAnyOlderThan20 = persons.stream()
                        .anyMatch(p -> p.getAge() > 20);
        System.out.println("isAnyOlderThan20 = " + isAnyOlderThan20);

        boolean isAllOlderThan20 = persons.stream()
                        .allMatch(p -> p.getAge() > 20);
        System.out.println("isAllOlderThan20 = " + isAllOlderThan20);

        boolean isNoneOlderThan20 = persons.stream()
                        .noneMatch(p -> p.getAge() > 20);
        System.out.println("isNoneOlderThan20 = " + isNoneOlderThan20);

        List<Person> adultPersons=persons.stream().
                filter(p -> p.getAge() > 18).collect(Collectors.toList());
        System.out.println("adultPersons = " + adultPersons);

        double averageAgeOfAdults=adultPersons.stream().
                mapToDouble(p -> p.getAge()).
                average().
                orElse(Double.NaN);
        System.out.println("averageAgeOfAdults = " + averageAgeOfAdults);

        List<Person> excludeTwoFirst=persons.stream().
                                    skip(2).
                                    collect(Collectors.toList());
        System.out.println("excludeTwoFirst = " + excludeTwoFirst);

        List<Person> notMoreThanThree=persons.stream().
                limit(3).
                collect(Collectors.toList());
        System.out.println("notMoreThanThree = " + notMoreThanThree);
        
        
        Optional<Person> firstAdult =  persons.stream().findFirst();
        System.out.println("firstAdult = " + firstAdult);

        Optional<Person> anyAdult =  persons.stream().findAny();
        System.out.println("anyAdult = " + anyAdult);

        List<Integer> ages =    persons.stream().
                                reduce(
                                new ArrayList<Integer>(),   //identity
                                (list, p) -> { list.add(p.getAge()) ; return list;},   //accumulator
                                (list1, list2) -> { list1.addAll(list2) ; return list1 ; }    //combiner
                        );

        System.out.println("ages = " + ages);

        Integer maxAge=
                persons.stream().
                        map(p -> p.getAge()).
                        reduce(0, (a, b) -> Integer.max(a, b));

        System.out.println("maxAge = " + maxAge);

        Optional<Person> oldest = persons.stream().
                reduce((res, item) -> res.getAge() > item.getAge() ? res : item);

        System.out.println("oldest = " + oldest);


    }

}
