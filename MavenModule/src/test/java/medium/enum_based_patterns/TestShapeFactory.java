package medium.enum_based_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShapeFactory {

    ShapeFactory factory;

    @BeforeEach
    void init() {
        factory = ShapeFactory.SQUARE;
    }


    @Test
    void whenCircle_thenCorrect() {
        var circle = factory.CIRCLE.create();
        circle.draw();
        Assertions.assertTrue(circle instanceof Circle);
    }


    @Test
    void whenSquare_thenCorrect() {
        var sq = factory.SQUARE.create();
        sq.draw();
        Assertions.assertTrue(sq instanceof Square);
    }

}
