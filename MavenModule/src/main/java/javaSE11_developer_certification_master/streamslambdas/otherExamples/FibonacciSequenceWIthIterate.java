package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FibonacciSequenceWIthIterate {


    static List<Integer>  calcFibonacciSequence(int length) {

        return Stream.
                iterate(new int[]{0,1}, pair -> new int[]{pair[1],pair[0]+pair[1]}).
                limit(length).
                map(pair -> pair[1]).
                collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> fibSeq=calcFibonacciSequence(10);
        System.out.println("fibSeq of length 10 = " + fibSeq);
    }

}
