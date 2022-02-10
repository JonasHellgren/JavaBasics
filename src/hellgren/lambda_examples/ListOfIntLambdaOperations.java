package hellgren.lambda_examples;

import java.util.Arrays;
import java.util.List;

public class ListOfIntLambdaOperations {

     @FunctionalInterface
     interface ListFunction {
         double apply(List<Integer> intList);
     }

    public static void main(String[] args) {

         List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);

        ListFunction sumOfList = (List<Integer> intList) -> {
            return intList.stream().mapToInt(Integer::intValue).sum();
            //alt: intList.stream().reduce(0,(a,b) -> a+b);
        };

        ListFunction avgOfList = (List<Integer> intList) -> {
            double sum=sumOfList.apply(intList);
            int n=intList.size();
            return (n==0?0:sum/n);
        };

        System.out.println("sumOfList.apply(numbers) = " + sumOfList.apply(numbers));
        System.out.println("avgOfList.apply(numbers) = " + avgOfList.apply(numbers));


    }

}
