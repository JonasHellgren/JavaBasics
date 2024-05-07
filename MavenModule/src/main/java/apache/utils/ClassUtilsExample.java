package apache.utils;

import org.apache.commons.lang3.ClassUtils;

import java.util.ArrayList;
import java.util.List;

public class ClassUtilsExample {
    public static void main(String[] args) {
        // Get all interfaces implemented by ArrayList
        System.out.println(ClassUtils.getAllInterfaces(ArrayList.class));

        // Get the canonical name of the class
        System.out.println(ClassUtils.getCanonicalName(ArrayList.class));

        // Check if the specified class can be cast to the reference class
        System.out.println(ClassUtils.isAssignable(ArrayList.class, List.class));
    }
}
