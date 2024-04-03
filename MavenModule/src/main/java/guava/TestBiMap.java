package guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * A BiMap is a bidirectional map that preserves the uniqueness of its values as well as its keys.
 *
 * This two-way map allows you to map keys to values and vice versa with equal ease, ensuring that
 * there is a unique inverse mapping.
 */

public class TestBiMap {

    public static void main(String[] args) {
        BiMap<String, Integer> userId = HashBiMap.create();
        userId.put("Alice", 1);
        userId.put("Bob", 2);

        System.out.println(userId.get("Alice")); // Outputs 1
        System.out.println(userId.inverse().get(2)); // Outputs Bob
    }
}
