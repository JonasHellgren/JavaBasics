package javaSE11_developer_certification_master.streamslambdas.five.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.five.Category;
import javaSE11_developer_certification_master.streamslambdas.five.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.five.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionAdvancedStreamsExercise04 {

    public static Map<Boolean, List<String>> getFoodAndNonFoodProductNames(List<Product> products) {
        // Partition the products into food and non-food products, and transform them into product names.
        //
        // Return a map where the food product names are under the key 'true' and the non-food product names are under the key 'false'.
        //
        // Hint: How do you map the products to product names after partitioning them?


        Map<Boolean, List<Product>>  trueFalseMap=products.stream().
                collect(Collectors.partitioningBy(p -> p.getCategory()== Category.FOOD));

        //TODO following can probably be solved cleaner
        List<Product> foodList=trueFalseMap.get(true);
        List<Product>  nonFoodList=trueFalseMap.get(false);
        Map<Boolean, List<String>>  result=new HashMap<>();
        result.put(true,new ArrayList<>());
        result.put(false,new ArrayList<>());
        foodList.forEach(p -> result.get(true).add(p.getName()));
        nonFoodList.forEach(p -> result.get(false).add(p.getName()));

        return result;

         /*
        List<Product> foodList=trueFalseMap.get(true);
        List<Product>  nonFoodList=trueFalseMap.get(false);
       //Map<Boolean, List<String>>  result=new HashMap<>();

        Map<Boolean, List<String>> result=trueFalseMap.get(true).stream().collect(
                HashMap::new,
                (list,p) -> list.add(p.getName()),
                HashMap::putAll);
                */
    }


    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Map<Boolean, List<String>> partitionedProducts=getFoodAndNonFoodProductNames(products);
        System.out.println("FOOD PRODUCTS: ");
        partitionedProducts.get(true).forEach(System.out::println);

        System.out.println("NON-FOOD PRODUCTS: ");
        partitionedProducts.get(false).forEach(System.out::println);
    }


}
