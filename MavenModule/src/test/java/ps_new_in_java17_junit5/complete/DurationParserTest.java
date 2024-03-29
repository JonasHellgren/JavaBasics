package ps_new_in_java17_junit5.complete;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pluralsight_new_in_java17.unit5_testing.code.complete.src.prescription.DurationParser;

import static org.junit.jupiter.api.Assertions.*;

class DurationParserTest {

    @ParameterizedTest
    @CsvSource({"2 weeks, 14", "1 month, 30", "5 days, 5", "once, 1"})
    public void parseDurationWithValidUnitAndQuantity(String durationString, int expectedDays) {
        assertEquals(expectedDays, DurationParser.parseDays(durationString));
    }

}