package ps_new_in_java17_junit5.junit5;

import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.apache.commons.math3.primes.Primes.isPrime;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;



public class DynamicTestTest {

    @TestFactory
    Stream<DynamicTest> generateTestCases(){

        Stream<Integer> inputStream = IntStream.range(0, 10).boxed();
        Function<Integer, String> displayName = input -> "Test input: " + input + " should be smaller than 10";
        ThrowingConsumer<Integer> testExecutor = input -> assertTrue(input < 10);

        return DynamicTest.stream(inputStream, displayName, testExecutor);
    }

    @TestFactory
    public List<DynamicTest> exampleTestFactory() {
        return Arrays.asList(
                dynamicTest("Dynamic square " + 2, () -> assertEquals(4, 2 * 2)),//
                dynamicTest("Dynamic true " + true, () -> assertTrue(true)));
    }

    @TestFactory
    Stream<DynamicTest> dynamicTestStream() {
        return IntStream.of(0, 2, 4, 6)
                .mapToObj(v ->
                        dynamicTest(v + " is a multiple of 2",()->assertEquals(0,v%2))
                );
    }

    @TestFactory
    Stream<DynamicNode> dynamicTestsFromCollection() {
        return Stream.of(7, 13)
                .map(number -> DynamicContainer.dynamicContainer("Prime or Odd Test"+number,
                        Stream.of(
                                DynamicTest.dynamicTest("is number "+number+" prime?",
                                        () -> assertTrue(isPrime(number))),
                                DynamicTest.dynamicTest("is number "+number+" odd?",
                                        () -> assertFalse(isEven(number))
                                ))));
    }

    private boolean isEven(Integer number) {
        return number % 2==0;
    }
}
