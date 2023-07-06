package pluralsight_new_in_java17.adv_java17.optional_test;

import org.junit.Test;
import pluralsight_new_in_java17.adv_java17.optional.Product;
import pluralsight_new_in_java17.adv_java17.optional.ProductsRepo;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.junit.Assert.*;

public class TestOptional {

    boolean flag;
    Consumer<Product> flagToTrue= p -> flag=true;

    @Test
    public void givenId1_thenExists() {
        Optional<Product> product= ProductsRepo.findById(1L);
        product.ifPresent(p -> flagToTrue.accept(p));

        assertTrue(product.isPresent());
        assertTrue(flag);
    }

    @Test
    public void givenId111_thenNotExists() {
        Optional<Product> product= ProductsRepo.findById(111L);
        product.ifPresentOrElse(p -> flagToTrue.accept(p),() -> flag=false);   //consumer, runnable

        assertFalse(product.isPresent());
        assertFalse(flag);
    }

    @Test
    public void givenId1_thenNameIsA() {
        String productName= ProductsRepo.nameOfId(1L);
        assertEquals("A",productName);
    }

    @Test
    public void givenId1111_thenNameIsEmpty() {
        String productName= ProductsRepo.nameOfId(111L);
        assertEquals("",productName);
    }

    @Test
    public void givenId1And2Discounted_thenNamesAAndB() {
        List<String> nameList= ProductsRepo.nameOfDiscounted(List.of(1L,2L));
        System.out.println("nameList = " + nameList);
        assertEquals(List.of("A","B"),nameList);
    }

    @Test
    public void givenId1And2Discounted_thenTwoProducts() {
        List<Product> productList= ProductsRepo.productsDiscounted(List.of(1L,2L));
        System.out.println("productList = " + productList);
        assertEquals(2,productList.size());
    }

}
