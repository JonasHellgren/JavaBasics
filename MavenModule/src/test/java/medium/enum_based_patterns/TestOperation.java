package medium.enum_based_patterns;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestOperation {

    @BeforeEach
    void init() {
        int x = 10, y = 5;
        for (Operation op : Operation.values()) {
            System.out.printf("%d %s %d = %d%n", x, op.name(), y, op.apply(x, y));
        }
    }

    @Test
    void test_add() {
        int x = 10, y = 5;
        int sum = Operation.ADD.apply(x, y);
        Assertions.assertEquals(15, sum);
    }

    @Test
    void test_sub() {
        int x = 10, y = 5;
        int sum = Operation.SUBTRACT.apply(x, y);
        Assertions.assertEquals(5, sum);
    }


    @Test
    void test_mul() {
        int x = 10, y = 5;
        int sum = Operation.MULTIPLY.apply(x, y);
        Assertions.assertEquals(50, sum);
    }


    @Test
    void test_div() {
        int x = 10, y = 5;
        int sum = Operation.DIVIDE.apply(x, y);
        Assertions.assertEquals(2, sum);
    }

}
