package effective_java.E_generics_tests.item30;

import effective_java.E_generics.item30.SetJoiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestSetJoiner {

    @Test
    public void testUnion() {

        Set<Integer> set1=new HashSet<>(Arrays.asList(1, 2));
        Set<Integer> set2=new HashSet<>(Arrays.asList(3,4));
        Set<Integer> setUnion= SetJoiner.union(set1,set2);

        System.out.println("set1 = " + set1);
        System.out.println("setUnion = " + setUnion);

        setUnion.contains(3);


    }

}
