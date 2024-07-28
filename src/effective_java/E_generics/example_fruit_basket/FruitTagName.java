package effective_java.E_generics.example_fruit_basket;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FruitTagName implements FruitTagI{

    String tag;

    @Override
    public String tag() {
        return tag;
    }

    @Override
    public String toString() {
        return tag;
    }
}
