package ps_new_in_java17_junit5.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationUnitTest {

    @Test
    public void matchUnitBySingularString() {
        assertEquals(DurationUnit.WEEK, DurationUnit.getByTextValue("week"));
    }

    @Test
    public void matchUnitByPluralString() {
        assertEquals(DurationUnit.WEEK, DurationUnit.getByTextValue("weeks"));
    }



}