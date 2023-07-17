package javaSE11_developer_certification_master.streamslambdas.two.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.two.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.two.Product;

import java.util.List;

public class SolutionLambdasExercise01 {

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();

        products.sort((Product p1, Product p2) -> {
            return p1.getName().compareTo(p2.getName());
        });

        for (Product product : products) {
            System.out.println(product);
        }
    }

}
