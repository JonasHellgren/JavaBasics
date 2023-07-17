package javaSE11_developer_certification_master.streamslambdas.five.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.five.Category;
import javaSE11_developer_certification_master.streamslambdas.five.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.five.Product;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionAdvancedStreamsExercise02 {

    public static Map<Category, Long> countProductsPerCategory(List<Product> products) {
        //Group the products by category and count the number of products in each category.
        return products.stream().
                collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.counting()));
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Map<Category, Long> countedProducts = countProductsPerCategory(products);
        System.out.println("countedProducts = " + countedProducts);
    }

}
