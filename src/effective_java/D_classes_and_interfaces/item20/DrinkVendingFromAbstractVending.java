package effective_java.D_classes_and_interfaces.item20;

public class DrinkVendingFromAbstractVending  extends AbstractVending {
    @Override
    public void chooseProduct() {
        System.out.println("Produce different soft drinks");
        System.out.println("Choose a type of soft drinks");
        System.out.println("pay for drinks");
        System.out.println("collect drinks");
    }
}