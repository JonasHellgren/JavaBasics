package jupiter_tests;

import org.apache.commons.lang3.math.NumberUtils;
import org.hellgren.utilities.math.MyMathUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TestWithMethodSource {

    @ParameterizedTest
    @MethodSource("provideEvenNumbers")
     void testIsEven(int number) {
        assertTrue(MyMathUtils.isEven(number),
                () -> "Number " + number + " should be even.");
    }

    static Stream<Integer> provideEvenNumbers() {
        return Stream.of(2, 4, 6, 8, 10);  // Define the test data
    }
}
