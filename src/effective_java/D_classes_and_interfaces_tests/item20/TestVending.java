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

    @Test
    public void testVendingSkeleton() {
        AbstractVending candy =  new CandyVendingFromAbstractVending();  //Ivending isf AbstractVending does not work
        AbstractVending drink =  new DrinkVendingFromAbstractVending();
        candy.process();
        System.out.println("*********************");
        drink.process();
    }

}
