package packt_Java_coding_problems;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMapCopy {

    public static <K, V> HashMap<K, V> shallowCopy(Map<K, V> map) {
        HashMap<K, V> copy = new HashMap<>();
        copy.putAll(map);
        return copy;
    }

    HashMap<String,Integer>  map=new HashMap<>();

    @Test
    public void TestMapCopy() {

        map.put("1",1);
        map.put("2",2);
        map.put("3",3);
        map.put("4",4);

        HashMap<String,Integer> copy=shallowCopy(map);
        System.out.println(copy);


    }



}
