package pluralsight_new_in_java17.playbook;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestMapDuplicates {

    Map<String,Integer> personMap =Map.of(
            "Ted", 5,"Alex",4,"Dag",4
    );


    @Test
    public void whenIsThereDuplicates_thenCorrect() {
        assertTrue(isDuplicateInMap(personMap));
    }

    @Test
    public void whenDuplicateValues_thenCorrect() {
        assertEquals(List.of(4),duplicateValuesInMap(personMap));
    }

    @Test
    public void whenFrequencyOfValues_thenCorrect() {
        assertEquals(2,Collections.frequency(List.of(1,2,3,3),3));
    }

    @Test
    public void whenDistinctValues_thenCorrect() {
        assertEquals(List.of(1,2), Stream.of(1,1,1,1,1,2,2).distinct().toList());
    }

    static <K,V> boolean isDuplicateInMap(Map<K,V> map) {
        Collection<V> values=map.values();
        Set<V> valueSet=new HashSet<>(values);
        return values.size()!=valueSet.size();
    }



    static <K,V> List<V> duplicateValuesInMap(Map<K,V> map) {
        return map.values().stream()
                .filter(v -> Collections.frequency(map.values(),v)>1)
                .distinct()  //remove duplicates in stream
                .toList();
    }
}
