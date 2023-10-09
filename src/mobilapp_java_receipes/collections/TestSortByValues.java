package mobilapp_java_receipes.collections;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestSortByValues {

    @Test
    public void test() {
        var dic = new HashMap<String, Integer>() {{
            put("B",2);
            put("C",3);
            put("A",1);
        }};

        var sortedDic = sortByValue(dic);
        System.out.println("sortedDic = " + sortedDic);

        List<Integer> values=sortedDic.values().stream().toList();

        Assert.assertEquals(1,values.get(0).intValue());


    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =  new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue());

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            temp.put(entry.getKey(), entry.getValue());
        }
        return temp;
    }


}
