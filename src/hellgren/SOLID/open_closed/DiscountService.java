package hellgren.SOLID.open_closed;

import hellgren.SOLID.open_closed.Discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DiscountService {

    public List<Double>  applyDiscounts(double price, List<Discount> discounts) {

        List<Double> priceList=new ArrayList<>();
        for(Discount discount:discounts) {
            priceList.add(discount.apply(price));
        }

        return priceList;
    }
}
