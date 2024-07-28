package effective_java.E_generics.example_fruit_basket;

import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class Apple implements FruitI<AppleProperties> {

    AppleProperties properties;

    public static Apple of(Color color, Integer diameter) {
        var properties=new AppleProperties(color,diameter);
        return new Apple(properties);
    }

    @Override
    public void showProperties() {
        System.out.println(propertiesAsString());
    }

    private String propertiesAsString() {
        return "Color = " + properties.color + ", diameter=" + properties.diameter;
    }

    @Override
    public AppleProperties getProperties() {
        return properties;
    }


    @Override
    public String toString() {
        return "Banana with properties:"+propertiesAsString();
    }

}
