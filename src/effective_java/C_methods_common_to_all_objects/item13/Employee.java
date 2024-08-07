package effective_java.C_methods_common_to_all_objects.item13;

import lombok.AllArgsConstructor;
import lombok.ToString;

//http://javadeveloperkit.com/create-copy-of-object-by-copy-constructor-static-factory-in-java/
@AllArgsConstructor
@ToString
public class Employee {

    private final String name;
    private final String identifier;
    public Address address;

    public Employee(Employee e) { //Copy constructor for Employee.
        this.name = e.name;
        this.identifier = e.identifier;
        this.address = new Address(e.address);
    }

    public Employee getCopy() {
        return new Employee(this);
    }

}

