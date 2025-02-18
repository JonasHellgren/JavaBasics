package medium.enum_based_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestTrafficLight {

    @Test
    void whenRed_thenNextIsGreen() {
        var tl = TrafficLight.RED;
        var next = tl.next();
        Assertions.assertEquals(TrafficLight.GREEN, next);
    }

    @Test
    void whenYellow_thenNextIsRed() {
        var tl = TrafficLight.YELLOW;
        var next = tl.next();
        Assertions.assertEquals(TrafficLight.RED, next);
    }

    @Test
    void whenGreen_thenNextIsYellow() {
        var tl = TrafficLight.GREEN;
        var next = tl.next();
        Assertions.assertEquals(TrafficLight.YELLOW, next);
    }

}
