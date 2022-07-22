package java_design_patterns.N_template.order;


abstract class OrderProcessTemplate implements  OrderProcessInterface
{

    public final void processOrder(boolean isGift)
    {
        doSelect();
        doPayment();
        if (isGift) {
            giftWrap();
        }
        doDelivery();
    }

    public abstract void doSelect();
    public abstract void doPayment();
    public final void giftWrap()
    {
        try
        {
            System.out.println("Gift wrap successful");
        }
        catch (Exception e)
        {
            System.out.println("Gift wrap unsuccessful");
        }
    }

    public abstract void doDelivery();

}
