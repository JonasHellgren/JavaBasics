package effective_java.C_methods_common_to_all_objects.item13;


import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ContractEmployee extends Employee{
    public int dailyWages;

    public ContractEmployee(Employee e, int dailyWages) {
        super(e);
        this.dailyWages = dailyWages;
    }

    public ContractEmployee(ContractEmployee emp ) { // Copy constructor for ContractEmployee
        super(((Employee)emp));
        this.dailyWages = emp.dailyWages;
    }

    public  ContractEmployee getCopy() {  // Static factory implementation
        return new ContractEmployee(this);  // static factory invokes copy constructor
    }

}
