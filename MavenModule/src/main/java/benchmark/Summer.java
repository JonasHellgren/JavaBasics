package benchmark;

import java.util.List;

public class Summer {

    public static long sumArray(int[] array) {
        long sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }

    public static long sumList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue) // Converts Integer to int
                .sum();
    }

}
