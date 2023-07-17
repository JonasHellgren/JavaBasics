package javaSE11_developer_certification_master.streamslambdas.otherExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringLengthWithMapToInt {

    public static void main(String[] args) {

    List<String> list = Arrays.asList("Geeks", "for", "gfg",
            "GeeksforGeeks", "GeeksQuiz");

    List<Integer> strLength=list.stream().
            mapToInt(str -> str.length()).
            collect(ArrayList::new,ArrayList::add,ArrayList::addAll);


        System.out.println("strLength = " + strLength);


    }

}
