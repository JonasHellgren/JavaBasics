package pluralsight_new_in_java17.playbook;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import java.text.DecimalFormat;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TestCollections {

    List<String> list1=List.of("A","B","C");
    List<String> list2=List.of("A","B");

    @Test
    public void whenGettingIntersectionInTwoList_thenCorrect() {
        Set<String> same = getIntersection(list1, list2);
        assertEquals(Set.of("A","B"),same);
    }

    @Test
    public void whenGettingDifferenceInTwoList_thenCorrect() {
        Set<String> difference = getDifference(list1, list2);
        assertEquals(Set.of("C"),difference);
    }

    private static Set<String> getDifference(List<String> list1, List<String> list2) {
        Set<String> union = getUnion(list1, list2);
        Set<String> difference = new HashSet<>(union);
        difference.removeAll(getIntersection(list1, list2));
        return difference;
    }

    private static Set<String> getUnion(List<String> list1, List<String> list2) {
        Set<String> union=new HashSet<>(list1);
        union.addAll(list2);
        return union;
    }

    private static Set<String> getIntersection(List<String> list1, List<String> list2) {
        Set<String> same=new HashSet<>(list1);
        same.retainAll(list2);
        return same;
    }

}
