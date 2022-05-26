package pluralsight_courses.pluralsight_java_basics.testlists;

import java.util.LinkedList;
import java.util.List;

public class testLinkedList {

    static public void runtest(Product door, Product floorpanel, Product window) {

        List<Product> products = new LinkedList<>();
        products.add(door);   products.add(floorpanel);   products.add(window);

        System.out.println("testLinkedList: Print by using toString of Product class");
        System.out.println(products);
        System.out.println("testLinkedList: Access Element 2: " + products.get(2));
        System.out.println("List contains door is " + products.contains(door));
    }

}
