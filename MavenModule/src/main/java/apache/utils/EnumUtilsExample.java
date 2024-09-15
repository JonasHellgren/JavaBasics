package apache.utils;

import org.apache.commons.lang.enums.EnumUtils;


public class EnumUtilsExample {

    public enum Status {
        PENDING, PROCESSING, COMPLETED
    }

    public static void main(String[] args) {

        // Get the enum list
        System.out.println(EnumUtils.getEnumList(Status.class));


        var list=EnumUtils.getEnumList(Status.class);
        System.out.println("list = " + list);

        var map=EnumUtils.getEnumMap(Status.class);
        System.out.println("map = " + map);
        System.out.println("map.keySet() = " + map.keySet());  //strings
    }
}
