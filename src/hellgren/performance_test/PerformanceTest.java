package hellgren.performance_test;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.List;

//@Log
public class PerformanceTest {

    public static void main(String[] args) {
        List<Integer> intList= Arrays.asList(1,2,3,4,5,6,7,8,9);
        for (int i = 0; i < 1_000 ; i++) {
            int sum=sumIntList(intList);
         //   log.fine("sum = " + sum);
            int prod=productIntegerList(intList);
         //   log.fine("prod = " + prod);
        }
    }


    public static Integer sumIntList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    @SneakyThrows
    public static Integer productIntegerList(List<Integer> list) {
        Thread.sleep(1);
        return list.stream().mapToInt(x->x).reduce(1, Math::multiplyExact);
    }

}
