package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ParallelStreamAdding {

    public static final int START_NUM=1;
    public static final int CORRECT_SUM=11;

    public static void main(String[] args) {

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int sum1= listOfNumbers.parallelStream().reduce(START_NUM,Integer::sum);
        int nofThreadsUsed=sum1-CORRECT_SUM;
        //The actual result might differ depending on the number of threads used in the common fork-join pool.
        //In order to fix this issue, the number five should be added outside of the parallel stream:
        int sum2 = listOfNumbers.parallelStream().reduce(0,Integer::sum)+START_NUM;

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("nofThreadsUsed = " + nofThreadsUsed);

    }
}
