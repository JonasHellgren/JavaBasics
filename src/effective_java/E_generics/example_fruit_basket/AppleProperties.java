package effective_java.E_generics.example_fruit_basket;

import java.awt.*;

public class AppleProperties extends CommonFruitProperty {
    int diameter;

    public AppleProperties(Color color,int diameter) {
        this.color=color;
        this.diameter = diameter;
    }
}
