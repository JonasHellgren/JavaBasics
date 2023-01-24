package hellgren.SOLID.open_closed;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class AbsoluteDiscount implements Discount{

    double discount;

    public AbsoluteDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public double apply(double price) {

        return  price-discount;
    }
}
