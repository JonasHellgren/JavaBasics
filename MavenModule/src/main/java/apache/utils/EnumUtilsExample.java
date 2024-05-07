package apache.utils;

import org.apache.commons.lang3.EnumUtils;

public class EnumUtilsExample {

    public enum Status {
        PENDING, PROCESSING, COMPLETED
    }

    public static void main(String[] args) {
        // Check if enum contains a specific name
        System.out.println(EnumUtils.isValidEnum(Status.class, "PENDING"));

        // Get the enum list
        System.out.println(EnumUtils.getEnumList(Status.class));

        // Convert a string to an enum
        Status status = EnumUtils.getEnum(Status.class, "COMPLETED");
        System.out.println(status);

        var list=EnumUtils.getEnumList(Status.class);
        System.out.println("list = " + list);

        var map=EnumUtils.getEnumMap(Status.class);
        System.out.println("map = " + map);
        System.out.println("map.keySet() = " + map.keySet());  //strings
    }
}
