package com.pluralsight.testlists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class testArrayList {
    static public void runtest(Product door, Product floorpanel, Product window) {

    List<Product> products = new ArrayList<>();
        products.add(door);   products.add(floorpanel);   products.add(window);

        System.out.println("testArrayList: Print by using toString of Product class");
        System.out.println(products);

        System.out.println("testArrayList: Print by using iterator of Product class");
    final Iterator<Product> proditer1 = products.iterator();
        while (proditer1.hasNext()) {
        Product product = proditer1.next();     System.out.println(product);    }

        System.out.println("testArrayList: Print by using for");
        for (Product product : products)  {System.out.println(product);}

        System.out.println("testArrayList: Print only heavy products by using iterator");
    final Iterator<Product> proditer2 = products.iterator();  //need to define new iterator
            while (proditer2.hasNext()) {
        Product product = proditer2.next();
        if (product.getMass()>20)       System.out.println(product);  //filter out if heavy
    }
    }
}
