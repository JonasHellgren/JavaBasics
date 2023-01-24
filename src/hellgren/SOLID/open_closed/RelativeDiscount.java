package hellgren.SOLID.open_closed;

public class RelativeDiscount implements Discount {

    private final double relativeDiscount;

    public RelativeDiscount(double relativeDiscount) {

        this.relativeDiscount = relativeDiscount/100;
    }

    @Override
    public double apply(double price) {

        return  price*(1-relativeDiscount);
    }
}
