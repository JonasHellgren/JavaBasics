package packt_Java_coding_problems;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestCounting {

    HashMap<String,Integer> map=new HashMap<>();

    @Test
    public void TestCounting() {

        map.put("1", 1);
        map.put("2", 2);
        map.put("3", 3);
        map.put("4", 4);

        List<Integer> targetList = new ArrayList<>(map.values());
        System.out.println(targetList);

        long nrOf3 = targetList.stream()
                .filter(m -> m == 3)
                .count();

        System.out.println(nrOf3);


    }

}
