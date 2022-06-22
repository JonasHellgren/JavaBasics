package effective_java.D_classes_and_interfaces_tests.item20;

import effective_java.D_classes_and_interfaces.item20.*;
import lombok.ToString;
import org.junit.Test;

public class TestVending {

    @Test
    public void testVending() {
        Ivending candy =  new CandyVending();
        Ivending drink =  new DrinkVending();
        candy.process();
        System.out.println("*********************");
        drink.process();
    }

    //avoid code duplication by defining common methods in AbstractVending, can still use interface for variable declaration
    @Test
    public void testVendingSkeleton() {
        Ivending candy =  new CandyVendingFromAbstractVending();
        Ivending drink =  new DrinkVendingFromAbstractVending();
        candy.process();
        System.out.println("*********************");
        drink.process();
    }

}
