package effective_java.E_generics.example_fruit_basket;

import lombok.AllArgsConstructor;

import java.awt.*;

public class BananaProperties extends CommonFruitProperty {
    int length;

    public BananaProperties(Color color, int length) {
        this.color=color;
        this.length = length;
    }
}
