package effective_java.J_exceptions_tests.examples;

import effective_java.J_exceptions.examples.InvalidProductException;
import effective_java.J_exceptions.examples.Product;
import org.junit.Test;

public class TestProduct {

    public static final int WEIGHT_TO_HIGH = 160;

    @Test
    public void testInvalidProduct() {

        Product obj = new Product();
        try
        {
            obj.productCheck(WEIGHT_TO_HIGH);
        }
        catch (InvalidProductException ex)
        {
            System.out.println("Caught the exception");
            System.out.println(ex.getMessage()+", weight = "+ex.getWeight());
        }

    }

    @Test(expected = InvalidProductException.class)
    public void toHeavyShallThrowException() throws InvalidProductException {
        Product obj = new Product();
        obj.productCheck(110);
    }


    @Test(expected = Test.None.class )  ///no exception expected
    public void notToHeavyShallNotThrowException() throws InvalidProductException {
        Product obj = new Product();
        obj.productCheck(10);
    }

}
