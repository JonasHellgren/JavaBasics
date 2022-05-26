package pluralsight_courses.pluralsight_java_basics.testlists;

public class Main {
    public static void main(String[] args) {

    Product door = new Product("Wooden door", 35);
    Product floorpanel = new Product("Floor Panel", 25);
    Product window = new Product("Glass window", 10);

    testArrayList.runtest(door,floorpanel,window);
     testLinkedList.runtest(door,floorpanel,window);
    }
}
