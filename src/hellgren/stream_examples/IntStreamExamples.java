package hellgren.stream_examples;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/***
 * https://howtodoinjava.com/java8/intstream-examples/
 */


public class IntStreamExamples {

    @AllArgsConstructor
    @Getter
    @ToString
    static
    class ActionRewardResult {
        public int action;
        public double reward;
    }

    public static void main(String[] args) {

        IntStream ints1=IntStream.of(1, 2, 3);  //1,2,3
        printStream(ints1);

        System.out.println("generate");
        IntStream ints2=IntStream.generate(  () -> { return (int) (Math.random()*100  ); } ) ;
        printStream(ints2);

        System.out.println("rangeClosed");
        IntStream ints3=IntStream.rangeClosed(0,5-1);   //for (int i = 0; i < 5 ; i++)
        printStream(ints3);

        System.out.println("range");
        IntStream ints4=IntStream.range(0,5);  //for (int i = 0; i < 5 ; i++)
        printStream(ints4);

        System.out.println("intList");
        List<Integer> intList=IntStream.range(0,5).boxed().collect(Collectors.toList());  //boxed => Integer
        intList.forEach(i -> System.out.println(i));

        System.out.println("String stream");
        IntStream ints5=IntStream.of(1, 2, 3,4);
        Stream<String> stringStream= ints5.mapToObj(n -> {return String.valueOf(n);});
        stringStream.forEach(s -> System.out.println(s));

        System.out.println("ActionRewardResult stream");
        IntStream ints6=IntStream.of(1, 2, 3,4);
        Stream<ActionRewardResult> actionRewardResultStream1= ints6.mapToObj(n -> new ActionRewardResult(n,n*n));
        actionRewardResultStream1.forEach(arr -> System.out.println(arr));

        System.out.println("Best ActionRewardResult");
        IntStream ints7=IntStream.of(1, 2, 3,4);
        Stream<ActionRewardResult> actionRewardResultStream2= ints7.mapToObj(n ->  new ActionRewardResult(n,n*n));
        Optional<ActionRewardResult> maxReward = actionRewardResultStream2.
                reduce((res, item) -> res.getReward() > item.getReward() ? res : item);

        ActionRewardResult res= maxReward.orElse(new ActionRewardResult(0,0));
        System.out.println(res);

    }

    private static void printStream(IntStream ints) {
        ints.limit(10).forEach(i -> System.out.println(i));
    }

}
