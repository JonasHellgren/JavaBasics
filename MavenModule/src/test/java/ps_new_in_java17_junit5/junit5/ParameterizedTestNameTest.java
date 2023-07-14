package ps_new_in_java17_junit5.junit5;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

public class ParameterizedTestNameTest {



    @ParameterizedTest
    @ValueSource(strings = {"Adel","Amid","Anders"})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertStartsWithA(input);
    }
    
    @ParameterizedTest
    @MethodSource("nameList")
    public void paramTest(String name) {
        assertStartsWithA(name);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void csvTest(String name) {
        assertStartsWithA(name);
    }

    private static void assertStartsWithA(String name) {
        Assertions.assertTrue(name.startsWith("A"));
    }


    private static List<String> nameList() {
        return Arrays.asList("Adel","Amid","Anders");
    }

}
