package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamBasicPrint {

    public static void main(String[] args) {

        List<Integer> listOfNumbers= Arrays.asList(1,2,3,4,5);

        listOfNumbers.parallelStream().
                forEach(n -> System.out.println("Number = "+n+" is managed by thread = "+Thread.currentThread().getName()));

    }

}
