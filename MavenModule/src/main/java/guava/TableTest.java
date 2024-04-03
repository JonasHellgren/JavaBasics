package guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * Think of it as a Map with two keys!
 */

public class TableTest {

    public static void main(String[] args) {

        Table<String, String, Integer> universityCourseSeats = HashBasedTable.create();
        universityCourseSeats.put("Computer Science", "CS101", 30);
        universityCourseSeats.put("Mathematics", "MA101", 25);

        System.out.println(universityCourseSeats.get("Computer Science", "CS101")); // Outputs 30
    }

}
