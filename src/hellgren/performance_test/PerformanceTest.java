package hellgren.performance_test;

import java.util.Arrays;
import java.util.List;

public class PerformanceTest {

    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(1,2,3,4,5,6,7,8,9);
        for (int i = 0; i < 10000 ; i++) {
            int sum=sumIntList(intList);
            int prod=productIntegerList(intList);
        }
    }


    public static Integer sumIntList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    public static Integer productIntegerList(List<Integer> list) {
        return list.stream().mapToInt(x->x).reduce(1, Math::multiplyExact);
    }

}
