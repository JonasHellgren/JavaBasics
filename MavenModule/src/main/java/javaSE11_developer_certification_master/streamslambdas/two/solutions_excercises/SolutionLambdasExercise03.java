package javaSE11_developer_certification_master.streamslambdas.two.solutions_excercises;


import javaSE11_developer_certification_master.streamslambdas.five.ExampleData;
import javaSE11_developer_certification_master.streamslambdas.five.Product;

import java.util.ArrayList;
import java.util.List;

public class SolutionLambdasExercise03 {

    public interface ShoppingCartFactory {
        ShoppingCart newShoppingCart();
    }

    public static ShoppingCartFactory getShoppingCartFactory() {

        //ShoppingCartFactory sc=() -> new  ShoppingCart();

        return ShoppingCart::new;
    }

    public static class ShoppingCart {
        protected final List<Product> products = new ArrayList<>();

        public void add(Product product) {
            this.products.add(product);
        }
    }

        public static void main(String[] args) {
            List<Product> products = ExampleData.getProducts();

            ShoppingCartFactory scf = getShoppingCartFactory();
            ShoppingCart sc = scf.newShoppingCart();

            sc.add(products.get(0));
            sc.products.forEach(System.out::println);

            System.out.println("sc.products.size() = " + sc.products.size());

        }
}

