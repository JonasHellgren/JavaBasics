package effective_java.E_generics.example_fruit_basket;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Basket<K extends FruitTagI, V extends FruitI<?>> {  //extends <=> sub class
    private final List<TagFruitPair<K, V>> pairs;

    public Basket() {
        this.pairs = new ArrayList<>();
    }

    public void addPair(K key, V value) {
        pairs.add(new TagFruitPair<>(key, value));
    }

    //variant 1

    public static Basket<FruitTagI, FruitI<?>> createBasketWithFruits() {
        Basket<FruitTagI, FruitI<?>> basket = new Basket<>();
        basket.addPair(new FruitTagName("Red Apple"), Apple.of(Color.RED, 5));
        basket.addPair(new FruitTagName("Short Banana"), Banana.of(Color.YELLOW, 10));
        basket.addPair(new FruitTagName("Green apple"), Apple.of(Color.GREEN, 5));
        basket.addPair(new FruitTagName("Long Banana"), Banana.of(Color.YELLOW,20));
        return basket;
    }

    //variant 2

    public void addSomeFruits() {
        addFruitPair(new FruitTagName("Red Apple"), Apple.of(Color.RED, 5));
        addFruitPair(new FruitTagName("Short Banana"), Banana.of(Color.YELLOW, 10));
        addFruitPair(new FruitTagName("Green apple"), Apple.of(Color.GREEN, 5));
        addFruitPair(new FruitTagName("Long Banana"), Banana.of(Color.YELLOW,20));
    }

    public void addFruitPair(FruitTagI key, FruitI<?> value) {
        pairs.add(new TagFruitPair<>((K) key, (V) value));
    }

    public List<TagFruitPair<K, V>> getPairs() {
        return pairs;
    }

    public void clear() {
        pairs.clear();
    }

    public void showPairs() {
        for (TagFruitPair<K, V> pair : pairs) {
            System.out.println(pair);
        }
    }
}