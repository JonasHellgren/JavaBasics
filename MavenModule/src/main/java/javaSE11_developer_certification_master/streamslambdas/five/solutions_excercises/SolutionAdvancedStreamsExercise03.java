package javaSE11_developer_certification_master.streamslambdas.five.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.five.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.five.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SolutionAdvancedStreamsExercise03 {

    public enum PriceRange {
        CHEAP, MEDIUM, EXPENSIVE
    }

    public static Map<PriceRange, List<Product>> groupProductsByPriceRange(List<Product> products, BigDecimal cheapLimit, BigDecimal expensiveLimit) {
        // Group products by price range.
        // - A product is CHEAP if its price is less than cheapLimit.
        // - A product is EXPENSIVE if its price is more than expensiveLimit.
        // - A product is MEDIUM if its price is between cheapLimit and expensiveLimit.

        return products.stream().
                collect(Collectors.groupingBy(
                        p -> { if (p.getPrice().compareTo(cheapLimit) <= 0 )
                                    return PriceRange.CHEAP;
                            else if (p.getPrice().compareTo(expensiveLimit) <= 0)
                                    return PriceRange.MEDIUM;
                            else
                                    return PriceRange.EXPENSIVE;
                            }
                        ));
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        Map<PriceRange, List<Product>> priceGroupedProducts = groupProductsByPriceRange(products, new BigDecimal("5"), new BigDecimal("10") );

        priceGroupedProducts.forEach((category, productList) -> {
            System.out.println(category);
            productList.forEach(name -> System.out.println("- " + name));
        });

    }




}
