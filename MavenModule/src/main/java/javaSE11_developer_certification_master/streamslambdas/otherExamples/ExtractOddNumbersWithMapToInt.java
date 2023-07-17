package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExtractOddNumbersWithMapToInt {

    public static void main(String[] args) {

        // Creating a list of Strings
        List<String> list = Arrays.asList("3", "6", "8",
                "14", "15");

        List<Integer> evenNumbers1=list.stream().
                mapToInt(sn -> Integer.parseInt(sn)).
                filter(in -> in % 2 ==0).
                collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                //collect(Collectors.toList());  //mapToInt produces an IntStream, which doesn't have collect method taking a single Collector argument

        List<Integer> evenNumbers2=list.stream().
                mapToInt(sn -> Integer.parseInt(sn)).
                filter(in -> in % 2 ==0).
                boxed().
                collect(Collectors.toList());

        System.out.println("oddNumbers1 = " + evenNumbers1);

        System.out.println("oddNumbers2 = " + evenNumbers2);

    }



}
