package effective_java.E_generics.item30;

import java.util.HashSet;
import java.util.Set;

public class SetJoiner {

    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> unionSet=new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

}
