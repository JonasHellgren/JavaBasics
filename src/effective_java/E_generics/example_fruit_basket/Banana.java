package effective_java.E_generics.example_fruit_basket;

import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class Banana implements FruitI<BananaProperties> {

    BananaProperties properties;

    public static Banana of(Color color, int length) {
        var properties=new BananaProperties(color,length);
        return new Banana(properties);
    }

    @Override
    public void showProperties() {
        System.out.println(propertiesAsString());
    }

    private String propertiesAsString() {
        return "Color=" + properties.color + ", length=" + properties.length;
    }

    @Override
    public BananaProperties getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "Banana with properties:"+propertiesAsString();
    }

}
