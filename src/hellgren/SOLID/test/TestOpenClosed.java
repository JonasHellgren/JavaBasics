package hellgren.SOLID.test;

import hellgren.SOLID.open_closed.AbsoluteDiscount;
import hellgren.SOLID.open_closed.Discount;
import hellgren.SOLID.open_closed.DiscountService;
import hellgren.SOLID.open_closed.RelativeDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *  The non solid alternative is to have a Discount class that has separate methods for absolute and relative discounts.
 *  Thanks to polymorphism new discount classes can be added.
 *
 */

public class TestOpenClosed {


    @Test
    public void whenApplyDiscounts_thenAbsolutAndRelativeDiscount() {
        List<Discount> discounts=new ArrayList<>();
        discounts.add(new AbsoluteDiscount(10));
        discounts.add(new RelativeDiscount(10));

        DiscountService service=new DiscountService();

        List<Double> priceDiscountedList=service.applyDiscounts(1000,discounts);

        System.out.println("priceDiscountedList = " + priceDiscountedList);
        Assert.assertTrue(priceDiscountedList.containsAll(Arrays.asList(990d,900d)));

    }

}
