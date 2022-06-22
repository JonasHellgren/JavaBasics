package effective_java.creating_objects.item4;

public class UtilityClass {

    // Suppress default constructor for noninstantiability
    public UtilityClass() {
        throw new AssertionError();
    }

    public static void printHello() {
        System.out.println("Hello");
    }

}
