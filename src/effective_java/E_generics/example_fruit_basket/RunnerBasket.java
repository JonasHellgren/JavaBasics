package effective_java.E_generics.example_fruit_basket;

public class RunnerBasket {

    public static void main(String[] args) {
        Basket<FruitTagName, FruitI<?>> basket1 = new Basket<>();
        basket1.addSomeFruits();
        System.out.println("Basket 1");
        basket1.showPairs();

        System.out.println("Basket 2");
        var basket2=Basket.createBasketWithFruits();
        basket2.showPairs();

    }
}
