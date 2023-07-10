package pluralsight_new_in_java17.playbook;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class TestMapRemoveAndReplace {


    Map<String, Integer> personMap = Map.of(
            "Ted", 5, "Alex", 4, "Dag", 4, "Jonas", 49
    );

    Map<String, Integer> personMapMutable;

    @Before
    public void init() {
        personMapMutable = new HashMap<>(personMap);
    }

    @Test
    public void whenRemovingAdult_thenCorrect() {
        personMapMutable.entrySet().removeIf(e -> e.getValue() > 18);
        assertFalse(personMapMutable.containsKey("Jonas"));
    }

    @Test
    public void whenReplacing_thenCorrect() {
        personMapMutable.replace("Alex",personMapMutable.get("Alex")+1);
        assertEquals(5,personMapMutable.get("Alex").intValue());
    }
    @Test
    public void whenIncreasingAge_thenCorrect() {
        personMapMutable.computeIfPresent("Alex", (k,v) -> v+1);
        assertEquals(5,personMapMutable.get("Alex").intValue());
    }


}
