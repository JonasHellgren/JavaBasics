package junit5;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.Arrays;
import java.util.List;

public class TestJunit5 {

    @Test
    @RepeatedTest(value=5)
    public void test5Times() {
        Assertions.assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("nameList")
    public void paramTest(String name) {
        Assertions.assertTrue(name.startsWith("A"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv")
    public void csvTest(String name) {
        Assertions.assertTrue(name.startsWith("A"));
    }

    private static List<String> nameList() {
        return Arrays.asList("Adel","Amid","Anders");
    }

}
