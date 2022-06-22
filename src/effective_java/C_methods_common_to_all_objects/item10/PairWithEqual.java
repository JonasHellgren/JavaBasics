package effective_java.C_methods_common_to_all_objects.item10;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PairWithEqual {
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {

        //check if the argument is a reference to this object
        if (obj == this) return true;

        //check if the argument has the correct typ
        if (!(obj instanceof PairWithEqual)) return false;

        //For each significant field in the class, check if that field matches the corresponding field of this object
        PairWithEqual equalsSample = (PairWithEqual) obj;
        boolean isSameName = equalsSample.getName().equals(this.getName());
        boolean isSameAge = equalsSample.getAge()==this.getAge();
        if (isSameName && isSameAge) {
            return true;
        }

        return false;
}

}