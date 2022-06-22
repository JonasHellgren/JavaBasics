package effective_java.C_methods_common_to_all_objects.item14;

import lombok.Getter;
import lombok.ToString;

//https://www.geeksforgeeks.org/comparable-interface-in-java-with-examples/

@ToString
@Getter
public class ComparablePair  implements Comparable<ComparablePair> {
    String name;
    int age;

    public ComparablePair(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override public int compareTo(ComparablePair a)
    {
        // if the string are not equal
        if (this.name.compareTo(a.name) != 0) {
            return this.name.compareTo(a.name);
        }
        else {
            // we compare int values if the strings are equal
            return this.age - a.age;
        }
    }

    //cant @Override if not object, not clean to use equals on non object
    public boolean equals(ComparablePair op)  {
        return this.name.equals(op.name) && this.age==op.age;
    }

}

