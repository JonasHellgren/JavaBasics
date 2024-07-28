package effective_java.E_generics.example_fruit;


public class Banana implements FruitInterface<BananaProperties>
{
    BananaProperties bp;

    public Banana(BananaProperties bp) {
        this.bp = bp;
    }

    @Override
    public BananaProperties getProperties() {
        return bp;
    }

    @Override
    public void showProperties() {
        System.out.println("Banana length = "+bp.length);
    }

}
