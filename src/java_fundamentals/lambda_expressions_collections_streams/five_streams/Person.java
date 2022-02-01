package java_fundamentals.lambda_expressions_collections_streams.five_streams;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {

    final String name;
    final Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
