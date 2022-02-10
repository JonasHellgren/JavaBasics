package hellgren.lambda_examples;

import java.util.function.Function;

//http://tutorials.jenkov.com/java-functional-programming/functional-interfaces.html
public class JenkovTutorialOnLambdas {

    @FunctionalInterface
    interface OneIntParFcn extends Function<Integer, Integer> {
        @Override
        Integer apply(Integer integer);
    }

    public static void main(String[] args) {
        OneIntParFcn addWith3=(n -> n+3);
        Integer result = addWith3.apply(4);
        System.out.println("result = " + result);
    }

}
