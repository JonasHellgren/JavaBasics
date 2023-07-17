package javaSE11_developer_certification_master.streamslambdas.three.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.five.Category;
import javaSE11_developer_certification_master.streamslambdas.five.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.five.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SolutionFunctionalInterfacesExercise02 {

    public static class SearchCriteria {
        protected Category category;
        protected String namePattern;
        protected BigDecimal minimumPrice;
        protected BigDecimal maximumPrice;

        public SearchCriteria(Category category, String namePattern, BigDecimal minimumPrice, BigDecimal maximumPrice) {
            this.category = category;
            this.namePattern = namePattern;
            this.minimumPrice = minimumPrice;
            this.maximumPrice = maximumPrice;
        }
    }

    public static List<Product> filterProducts(List<Product> products, Predicate<Product> predicate) {
        List<Product> result = new ArrayList<>();
        for (Product product:products) {
            if (predicate.test(product)) {
                result.add(product);
            }
        }
        return result;
    }


    public static Predicate<Product> createSearchPredicate(SearchCriteria criteria) {
        Predicate<Product> categoryIs =product -> product.getCategory()==criteria.category;
        Predicate<Product> nameMatches = product -> product.getName().matches(criteria.namePattern);
        Predicate<Product> minimumPriceIs = product -> product.getPrice().compareTo(criteria.minimumPrice) >= 0;
        Predicate<Product> maximumPriceIs = product -> product.getPrice().compareTo(criteria.maximumPrice) <= 0;

        Predicate<Product> predicate = product -> true;

        if (criteria.category != null) {
            predicate=predicate.and(categoryIs);
        }

        if (criteria.namePattern != null) {
            predicate=predicate.and(nameMatches);
        }

        if (criteria.minimumPrice != null) {
            predicate=predicate.and(minimumPriceIs);
        }

        if (criteria.maximumPrice != null) {
            predicate=predicate.and(maximumPriceIs);
        }

        return predicate;
    }

    public static void main(String[] args) {
        List<Product> products = ExampleData.getProducts();
        SearchCriteria criteria=new SearchCriteria(Category.FOOD,"Tea",new BigDecimal("0"),new BigDecimal("10"));
        Predicate<Product> predicate=createSearchPredicate(criteria);
        List<Product> productList=filterProducts(products,  predicate);
        productList.forEach(p -> System.out.println(p));
    }

}
