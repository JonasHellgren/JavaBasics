package apache.runners;

import org.apache.commons.lang3.ObjectUtils;

import java.util.function.Supplier;

public class ObjectUtilsDemo {
    public static void main(String[] args) {
        // Default a null object to a predefined value
        String str = null;
        String defaultStr = ObjectUtils.defaultIfNull(str, "Default String");
        System.out.println(defaultStr);

        Supplier<String> defaultSupplier = () -> "hello-educative";
        String result = ObjectUtils.getIfNull(null, defaultSupplier);
        System.out.println("Result of ObjectUtils.getIfNull() when a null object is passed is " + result);

        System.out.println("The result is: " + result);

        // Compare two objects safely, considering nulls
        String str1 = "test";
        String str2 = null;
        boolean isEqual = ObjectUtils.equals(str1, str2);
        System.out.println("Is Equal: " + isEqual);

        String strClone=ObjectUtils.cloneIfPossible(str1);
        str1 = "changed";
        boolean notEq=ObjectUtils.notEqual(str1,strClone);

        System.out.println("strClone = " + strClone);
        System.out.println("strClone.equals(str1) = " + strClone.equals(str1));
        System.out.println("notEq = " + notEq);


        int int12=ObjectUtils.compare(1,2);
        int int21=ObjectUtils.compare(2,1);

        System.out.println("int12 = " + int12);
        System.out.println("int21 = " + int21);

        boolean anyNull=ObjectUtils.anyNull(str2,str1);
        System.out.println("anyNull = " + anyNull);







    }
}