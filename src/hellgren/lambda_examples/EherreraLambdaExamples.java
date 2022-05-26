package hellgren.lambda_examples;

import pluralsight_courses.lambda_expressions_collections_streams.two_predicate.Predicate;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;

//https://eherrera.net/ocpj8-notes/04-lambda-built-in-functional-interfaces
public class EherreraLambdaExamples {

    @NoArgsConstructor
    @Setter
    static
    class Product {
        private double price = 0.0;

        public void setPrice(double price) {
            this.price = price;
        }
        public void printPrice() {
            System.out.println("printPrice = " + price);
        }
    }


    public static void main(String[] args) {


        //Predicate
        Predicate<String> isALongWord = t -> t.length() >10;
        String s = "successfully";
        boolean predicateResult = isALongWord.test(s);
        System.out.println("predicateResult = " + predicateResult);

        //Consumer
        Consumer<Product> updatePrice = p -> p.setPrice(5);
        Product p = new Product();
        updatePrice.accept(p);
        p.printPrice();

        //Function
        Function<Integer,Integer> function = n -> n+10;
        int fcnResult = function.apply(10);
        System.out.println("fcnResult =" + fcnResult);

        //Supplier
        Supplier<Integer> aNumber=() -> 10;
        System.out.println("aNumber = "+aNumber.get());

        Supplier<List<Integer>> tenRandomNumbers= () -> {
            final int nofItems=10;
            final int maxValue=100;
            List<Integer> listOfNumbers=new ArrayList<>(nofItems);
            for (int i = 0; i < nofItems ; i++) {
                listOfNumbers.add(new Random().nextInt(maxValue));
            }
            return listOfNumbers;
        };

        System.out.println("hundredRandomNumbers = " + tenRandomNumbers.get());

        //primitive versions of functional interfaces
        IntPredicate positive = i -> i> 0;
        System.out.println("is ten positive = " + positive.test(10));

        //UnaryOperator
        //This is a specialization of the Function interface for the case where the operand and result are of the same type
        UnaryOperator<Integer> intUnary = v -> v * 10;
        // This means the same as the UnaryOperator above.
        Function<Integer, Integer> intFunction = v -> v * 10;
        System.out.println("intUnary = " + intUnary.apply(10));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.replaceAll(intUnary);
        System.out.println("list = " + list);


    }

}
