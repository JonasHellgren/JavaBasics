package ps_new_in_java17_junit5.junit5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestComplexTest {

    @ParameterizedTest
    @CsvSource({"test,TEST", "tEst,TEST", "Java,JAVA"})
    void toUpperCase_ShouldGenerateTheExpectedUppercaseValue(String input, String expected) {
        String actualValue = input.toUpperCase();
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @MethodSource("provideStringsForIsBlank")
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input, boolean expected) {
        assertEquals(expected, input.isBlank());
    }


    private static Stream<Arguments> provideStringsForIsBlank() {
        return Stream.of(
                Arguments.of("", true),
                Arguments.of("  ", true),
                Arguments.of("not blank", false)
        );
    }


    record Message(String message) {
    }

    //@DisplayName("Should pass same messages as method parameters")
    @ParameterizedTest(name = "{index} => actual={0}, expected={1}")
    @CsvSource({
            "Hello, Hello",
            "Hi, Hi",
    })
    void shouldPassMessages(Message actual, Message expected) {
        assertEquals(expected.message(), actual.message());
    }

    record Person(String name, int age) {
    }

    @ParameterizedTest
    @CsvSource({"John, 20",
            "Harry, 30"})
    void personIsNotBelow20(ArgumentsAccessor arguments) {
        Person person = new Person(arguments.getString(0),
                arguments.getInteger(1));
        assertTrue(person.age() > 19, person.name() + " is a teenager");
    }

    record IntegerSummer(int a, int b) {
        int sum() {
            return a + b;
        }
    }

    @ParameterizedTest
    @CsvSource({"1,1,2", "1,0,1", "101,10,111"})
    void whenSum_thenCorrect1(ArgumentsAccessor arguments) {
        int a = arguments.getInteger(0);
        int b = arguments.getInteger(1);
        Integer expectedSum = arguments.getInteger(2);

        IntegerSummer summer = new IntegerSummer(a, b);
        assertEquals(expectedSum, summer.sum());
    }

    @ParameterizedTest(name = "{index} => a={0}, b={1}, expectedSum={2}")
    @MethodSource("sumProvider")
    void whenSum_thenCorrect2(int a, int b, int expectedSum) {
        IntegerSummer summer = new IntegerSummer(a, b);
        assertEquals(expectedSum, summer.sum());
    }

    private static Stream<Arguments> sumProvider() {
        return Stream.of(
                Arguments.of(1, 1, 2),
                Arguments.of(2, 3, 5)
        );
    }

}
