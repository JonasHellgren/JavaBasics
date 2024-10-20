package hellgren.stream_examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class TopTenStreamOperationsMedium {

    record Person(String name, int age) {
    }

    public static void main(String[] args) {

        /**
         * map — arguably one of the most popular operations (and my personal favorite) is used to apply a
         * function to each element in the stream, producing a new stream of the transformed elements.
         * Example: we transform each pet name to uppercase using the map operation and collect the
         * resulting uppercase names into a new list using the toList collector.
         */
        List<String> pets = List.of("Hamster", "Cat", "Dog");
        List<String> upperCaseNames = pets.stream().map(String::toUpperCase).toList();
        assert List.of("HAMSTER", "CAT", "DOG").equals(upperCaseNames);

        List<Person> people = Arrays.asList(new Person("John", 25), new Person("Mary", 31), new Person("David", 42));

        List<Integer> ages = people.stream().map(p -> p.age).toList();
        assert List.of(25, 31, 42).equals(ages);

        /**
         *  filter is used to selectively include elements in the stream based on a specified condition.
         * Example: Using the filter operation, we selectively retain only the even numbers by applying a lambda
         * expression that checks if each number is divisible by 2 without a remainder. Subsequently, the toList
         * collector collects these even numbers into a new list.
         */


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = numbers.stream().filter(number -> number % 2 == 0).toList();
        assert List.of(2, 4, 6, 8, 10).equals(evenNumbers);

        /**
         collect accumulates elements from the stream into a collection, such as a List, Set, or Map (we
         have already used one of such collectors — toList above).

         Example: By using the collect method with the Collectors.toSet collector, we transform the stream
         of fruits into a set, ensuring uniqueness of elements.
         */

        List<String> fruits = List.of("apple", "peach", "banana", "cherry", "banana", "peach");
        Set<String> fruitSet = fruits.stream().collect(Collectors.toSet());
        assert fruitSet.size() == 4;

        /**
         flatMap is used to merge a stream of streams into a single stream, thus effectively flattening nested structures.

         Example: we start with a list of lists, where each inner list represents a category of shapes. By using the flatMap operation, we transform the stream of lists into a single stream of shapes, effectively flattening the nested structure. The resulting collection contains all the shapes from the original nested lists.
         */
        List<List<String>> shapes = List.of(List.of("triangle", "rectangle", "square"), // sharp forms
                List.of("circle", "ellipse", "cylinder") // rounded forms
        );

        List<String> flattenedShapes = shapes.stream().flatMap(shapesList -> shapesList.stream()).toList();

        assert flattenedShapes.size() == 6;
        assert List.of("triangle", "rectangle", "square", "circle", "ellipse", "cylinder").equals(flattenedShapes);

        /**
         reduce combines elements of the stream into a single result with an accumulation function, thus simplifying
         complex computations.

         Example: we apply the reduce operation to calculate the sum of all numbers in the list. The initial
         value of the accumulator is set to 0, and we use the Integer::sum method reference as the binary operator to perform the summation. The result, stored in the sum variable, represents the total sum of the numbers in the list.
         */
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        Integer sum = nums.stream().reduce(0, Integer::sum);
        assert sum == 15;

        List<Integer> nums2 = List.of(1, 2, 3, 4, 5);
        Integer count = nums2.stream().reduce(0, (a, b) -> a + 1);
        assert count == 5;

        /**
         forEach allows us to loop through each element in the stream, enabling us to perform an action.

         Example: forEach method iterate sover each element in the numbers list. Within the lambda expression, each number is multiplied by 2, resulting in the doubled value being printed to the console.
         */

        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5);
        numbers2.forEach(num -> System.out.println(num * 2));


        /**
         distinct removes duplicate elements from the stream, ensuring uniqueness in the output.

         Example: By chaining the distinct operation, we filter out duplicate elements, ensuring that each unique number appears only once in the resulting stream. The distinct numbers are then collected into a new list using the toList collector.

         */

        List<Integer> numbers3 = List.of(1, 2, 3, 4, 4, 4, 5);
        List<Integer> distinctNumbers = numbers3.stream().distinct().toList();
        assert List.of(1, 2, 3, 4, 5).equals(distinctNumbers);


        /**
         sorted is used to sort elements in the stream according to their natural order or a custom
         comparator that we provide.

         Example: with the sorted operation, we arrange the numbers in ascending order. The
         sorted numbers are then collected into a new list using the toList collector.

         */
        List<Integer> numbers4 = List.of(3, 1, 6, 8, 2, 4, 5, 9, 7);
        List<Integer> sorted = numbers4.stream().sorted().toList();
        assert List.of(1, 2, 3, 4, 5, 6, 7, 8, 9).equals(sorted);

        /**
         skip enables us to skip a designated number of elements from the start of the stream, while limit
         enables us to specify the maximum number of elements we wish to process from the beginning.

         Example: using the skip operation, we bypass the first 2 elements of the stream, resulting in a
         new stream containing elements starting from the third element onwards. Similarly, we use the limit operation to restrict the stream to only the first 3 elements.

         */
        List<Integer> numbers5 = List.of(1, 2, 3, 4, 5);
        List<Integer> skipped = numbers5.stream().skip(2).toList();
        assert List.of(3, 4, 5).equals(skipped);

        List<Integer> limited = numbers.stream().limit(3).toList();
        assert List.of(1, 2, 3).equals(limited);

        /**
         anyMatch, noneMatch, allMatch — these operations allow us to specify conditions and check if
         any, none, or all items in the stream match them.

         Example: we use the anyMatch, noneMatch, and allMatch operations to check if any, none, or
         all elements in the stream satisfy specific predicates. Each operation is chained to the stream
         of numbers, allowing us to efficiently evaluate the conditions.

         */
        numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        assert Boolean.TRUE.equals( // Is any of the numbers equal to 5?
                numbers.stream().anyMatch(num -> num == 5));

        assert Boolean.FALSE.equals( // Is any of the numbers equal to 15?
                numbers.stream().anyMatch(num -> num == 15));

        assert Boolean.TRUE.equals( // None of the numbers is equal to 15
                numbers.stream().noneMatch(num -> num == 15));

        assert Boolean.FALSE.equals( // None of the numbers is equal to 3
                numbers.stream().noneMatch(num -> num == 3));

        assert Boolean.TRUE.equals( // All of the numbers are greater than 0
                numbers.stream().allMatch(num -> num > 0));

        assert Boolean.FALSE.equals( // All of the numbers are even
                numbers.stream().allMatch(num -> num % 2 == 0));

        /**
         Optional
         Streams often work hand-in-hand with Optional to handle potentially absent values.
         */

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        Optional<String> first = names.stream() // Make a stream
                .findFirst();
        assert first.isPresent();

        Optional<Integer> any = numbers.stream().findAny();
        assert any.isPresent();

        Optional<Integer> max = numbers.stream().max(Integer::compare);
        assert max.isPresent();
        assert max.get().equals(10);

        Optional<Integer> min = numbers.stream().min(Integer::compare);
        assert min.isPresent();
        assert min.get().equals(1);


    }


}



