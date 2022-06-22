package effective_java.D_classes_and_interfaces.item20;

public class CandyVendingFromAbstractVending extends AbstractVending {

    @Override
    public void chooseProduct() {
        System.out.println("Produce diiferent candies");
        System.out.println("Choose a type of candy");
        System.out.println("pay for candy");
        System.out.println("collect candy");
    }
}