package effective_java.C_methods_common_to_all_objects_tests.item13;

import effective_java.C_methods_common_to_all_objects.item13.*;
import effective_java.C_methods_common_to_all_objects.item13.ContractEmployee;

import org.junit.Assert;
import org.junit.Test;

public class TestAddress {

    @Test
    public void testEmployee() {

        Address address = new Address("Street No1", "NJ");
        Employee employee1 = new Employee("John", "0001",address);
        ContractEmployee employee2 = new ContractEmployee(employee1,100);
      //  ContractEmployee employee3 = new ContractEmployee(employee1);  // Compilation error
        Employee employee4 = new Employee(employee2);   // Would compile, but child class variable would not be copied.

        Assert.assertFalse(employee1 == employee2);
        Assert.assertFalse(employee1.getClass().equals(employee2.getClass()));
        Assert.assertFalse(employee1.equals(employee2));

        System.out.println("employee2 = " + employee2);
        System.out.println("employee4 = " + employee4);

    }

    @Test
    public void testCopy() {

        Address address = new Address("Street No1", "NJ");
        Employee employee1 = new Employee("John", "0001", address);
        ContractEmployee employee2 = new ContractEmployee(employee1, 100);

        Employee emp1Copy=employee1.getCopy();
        ContractEmployee emp2Copy=employee2.getCopy();
        Employee emp3Copy=employee2.getCopy();  //compiles

        System.out.println("emp3Copy = " + emp3Copy);


        Assert.assertFalse(employee1==emp1Copy);
        Assert.assertEquals(employee1.address.getCity(),emp1Copy.address.getCity());
        Assert.assertEquals(employee2.address.getCity(),emp2Copy.address.getCity());
        Assert.assertEquals(employee2.getDailyWages(),emp2Copy.getDailyWages());

    }

}
