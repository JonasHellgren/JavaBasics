package pluralsight_courses.implementing_design_patterns_using_java_lambda.consumer;

import java.util.List;
import java.util.function.Consumer;

public class Consumers {

    public static Consumer<String> print = (x) -> System.out.println();

    public static Consumer<String> printLowerCase = (x) -> System.out.println(x.toLowerCase());

    // Consumer to multiply 2 to every integer of a list
    public static Consumer<List<Integer>> modifyMultiplyWithTwo = list ->
    {
        for (int i = 0; i < list.size(); i++)
            list.set(i, 2 * list.get(i));
    };

    // Consumer to subtract 1 to every integer of a list
    public static Consumer<List<Integer>> modifySubtractWithOne = list ->
    {
        for (int i = 0; i < list.size(); i++)
            list.set(i, list.get(i)-1);
    };

    // Consumer to display a list of integers
    public static Consumer<List<Integer> >
            showList = list -> list.stream().forEach(a -> System.out.print(a + " "));
}
