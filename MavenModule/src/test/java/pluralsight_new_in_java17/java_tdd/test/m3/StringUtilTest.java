package pluralsight_new_in_java17.java_tdd.test.m3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pluralsight_new_in_java17.java_tdd.m3.StringUtil;

import java.util.stream.Stream;

public class StringUtilTest {

    @ParameterizedTest
    @MethodSource("validLimitProvider")
    void limitReached_stringTruncates(int limit, String output) {
        String input = "The economy is about to";
        Assertions.assertEquals(output, StringUtil.truncate(input, limit));
    }

    static Stream<Arguments> validLimitProvider() {
        return Stream.of(
                Arguments.of(1, "T..."),    // min possible limit
                Arguments.of(11, "The economy...")
        );
    }

    @ParameterizedTest
    @MethodSource("inputOutputLimitProvider")
    void limitNotReached_stringNotChanged(String input, int limit) {
        Assertions.assertEquals(input, StringUtil.truncate(input, limit));
    }

    static Stream<Arguments> inputOutputLimitProvider() {
        String input = "The economy is about to";
        return Stream.of(
                Arguments.of(input, 40),
                Arguments.of(input, input.length()) // at border, input length == limit
        );
    }

    @ParameterizedTest
    @MethodSource("invalidArgumentProvider")
    void invalidInput_isRejected(String input, int limit) {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> StringUtil.truncate(input, limit));
    }

    static Stream<Arguments> invalidArgumentProvider() {
        return Stream.of(
                Arguments.of(null, 5),
                Arguments.of("Some input", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("shortInputLessOrEqualToEllipsis")
    void inputShorterOrEqualThanLimit_StringIsNotChanged(String input, int limit) {
        Assertions.assertEquals(input, StringUtil.truncate(input, limit));
    }

    static Stream<Arguments> shortInputLessOrEqualToEllipsis() {
        return Stream.of(
                Arguments.of("The", 2),
                Arguments.of("The", 3)
        );
    }
}
