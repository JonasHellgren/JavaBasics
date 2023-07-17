package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.Arrays;
import java.util.List;

public class SumOListWithReduce {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(-2, 0, 4, 6, 8);

        int sum = list.stream().
                reduce(0,  //initial value
                        (partRes, num) -> partRes + num);  //Accumulator – a function that takes two parameters: part result and next element

        System.out.println("sum = " + sum);


    }
}
