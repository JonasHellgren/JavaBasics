package effective_java.C_methods_common_to_all_objects_tests.item14;

import effective_java.C_methods_common_to_all_objects.item14.ComparablePair;
import effective_java.C_methods_common_to_all_objects.item14.Pair;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestPair {


    @Test
    public void testCompare() {

        ComparablePair p1 = new ComparablePair("a", 2);
        ComparablePair p2 = new ComparablePair("a", 4);

        System.out.println("p1.compareTo(p2) = " + p1.compareTo(p2));

        Assert.assertTrue(p1.compareTo(p2)<0);
    }

    @Test
    public void testSort() {
        ComparablePair[] arr = getComparablePairs();
        Arrays.sort(arr);
        print(arr);
        Assert.assertTrue(arr[0].equals(new ComparablePair("a", 2)));
    }


    @Test
    public void testAgeComparator() {
        Comparator<Pair> byAge = Comparator.comparingInt(Pair::getAge);
        //Comparator<Pair> byAge = (p1, p2) -> p1.getAge() - p2.getAge();

        Pair p1 = new Pair("a", 22);
        Pair p2 = new Pair("a", 4);
        List<Pair> pairList = Arrays.asList(p1, p2);
        pairList.sort(byAge);

        System.out.println("pairList = " + pairList);
        System.out.println("byAge.compare(p1,p2) = " + byAge.compare(p1, p2));

        Assert.assertEquals(4,pairList.get(0).getAge());
        Assert.assertTrue(byAge.compare(p1, p2)>0);
    }

    public static void print(ComparablePair[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private ComparablePair[] getComparablePairs() {
        int n = 4;
        ComparablePair arr[] = new ComparablePair[n];

        arr[0] = new ComparablePair("abc", 3);
        arr[1] = new ComparablePair("a", 4);
        arr[2] = new ComparablePair("bc", 5);
        arr[3] = new ComparablePair("a", 2);
        return arr;
    }


}
