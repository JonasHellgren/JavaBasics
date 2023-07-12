package ps_new_in_java17_junit5.complete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DurationUnitTest {

    @Test
    public void matchUnitBySingularString() {
        assertSame(DurationUnit.WEEK, DurationUnit.getByTextValue("week"));
    }

    @Test
    public void matchUnitByPluralString() {
        assertSame(DurationUnit.WEEK, DurationUnit.getByTextValue("weeks"));
    }

    @Test
    public void returnsNullForUnmatchedUnit() {
        assertNull(DurationUnit.getByTextValue("boop"));
    }

}