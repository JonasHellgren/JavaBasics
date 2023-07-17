package javaSE11_developer_certification_master.streamslambdas.otherExamples.models;

public class Person {
    String name;
    Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }

    static public Person oldest(Person p1, Person p2) {
        return p1.age > p2.age ? p1:p2;
    }

    @Override
    public String toString() {

        return "name = "+this.name+", age = "+this.age;

    }


}