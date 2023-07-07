package pluralsight_new_in_java17.playbook;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TestDecimalFormat {
    public static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.US); //US <=> only dots
    final double DEC_NUM = 1234567.89;

    @Test
    public void whenRoundedOneDecimal_thenCorrect() {
        DecimalFormat formatter = new DecimalFormat("#.#", SYMBOLS);
        assertEquals("1234567.9", formatter.format(DEC_NUM));
    }

    @Test
    public void whenRoundedOneDecimalMixingText_thenCorrect() {
        DecimalFormat formatter = new DecimalFormat("The cost is #.# Euro", SYMBOLS);
        assertEquals("The cost is 1234567.9 Euro", formatter.format(DEC_NUM));
    }

    @Test
    public void whenEngineeringNotation_thenCorrect() {
        DecimalFormat formatter = new DecimalFormat("#.######E0", SYMBOLS);
        assertEquals("1.234568E6", formatter.format(DEC_NUM));
    }

    @SneakyThrows
    @Test
    public void whenParsingString_thenCorrect() {
        DecimalFormat formatter = new DecimalFormat("", SYMBOLS);
        assertEquals(1.23, formatter.parse("1.23"));
    }

    @Test
    public void whenNumberFomatting_thenCorrect() {
        var formatter = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        assertEquals("100 million", formatter.format(100_000_000));
    }

    @Test
    public void whenMultipleOperationsAndRounding_thenCorrect() {
        DecimalFormat formatter = new DecimalFormat("#.#",SYMBOLS);
        List<Double> numbers = List.of(1.1, 2.2);
        List<String> stringList = numbers.stream()
                .map(n -> n + 1d).map(n -> n * 1.2)
                .map(n -> formatter.format(n))   //formatter gives string
                .toList();
        List<Double> modNumbers = stringList.stream()
                .map(s -> Double.parseDouble(s))
                .toList();

        System.out.println("modNumbers = " + modNumbers);

        assertEquals(List.of(2.5, 3.8), modNumbers);
    }


}
