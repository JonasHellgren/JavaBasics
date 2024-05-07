package collections;

import java.util.*;

/**
 * https://medium.com/javarevisited/5-lesser-known-java-collections-features-6ef3ba4c1fa6
 */

public class CollectionExamples {

    public static void main(String[] args) {
        List<String> tests = Collections.nCopies(10, "test");
        System.out.println(tests);

        List<Integer> integers = List.of(1, 2, 3, 4, 5, 1, 2, 3, 2, 3, 4);
        int frequency = Collections.frequency(integers, 3);
        System.out.println(frequency);

        //two collections have no common element, if yes then it returns true
        List<Integer> integers0 = List.of(1, 2, 3, 4);
        List<Integer> integers1 = List.of(5, 6);
        boolean disjoint = Collections.disjoint(integers0, integers1);
        System.out.println(disjoint);  //false

//The rotate performs a “circular rotation” of the elements in the list, effectively shifting
// them either to the left or right based on a specified distance.
        List<Integer> integers2 = Arrays.asList(1, 2, 3, 4, 5, 3, 5, 5, 6);
        Collections.rotate(integers2, -3);
        System.out.println(integers2);



        List<Double> empty=Collections.emptyList();
        System.out.println("empty = " + empty);

        int index=Collections.binarySearch(integers,4);

        Collection<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");

        boolean isIter=false;
        Iterator<Integer> iterator = isIter? integers.iterator(): Collections.emptyIterator();
        System.out.println("iterator.hasNext() = " + iterator.hasNext());


        List<String> src = List.of("Java","Python","C++");
        // Destination list, pre-initialized with null or default values
        List<String> dest = new ArrayList<>(List.of("","","Ruby","JavaScript"));
        Collections.copy(dest, src);
        // After copy, the contents of dest are modified
        System.out.println("Destination list after copy: " + dest);



        // Create a checked view of the collection
        Collection<String> checkedStrings = Collections.checkedCollection(strings, String.class);

        try {
            // This will not cause an error
            checkedStrings.add("Welcome");

            // This will cause a ClassCastException because the element is not a String
            Collection rawType = checkedStrings;
            rawType.add(100); // Attempting to add an integer to a collection of strings
        } catch (ClassCastException e) {
            System.out.println("Attempted to add an element of incorrect type: " + e.getMessage());
        }


        List<Double> listFilled=new ArrayList<>(5);
        listFilled.add(1d);
        Collections.fill(listFilled,10d);
        System.out.println("listFilled = " + listFilled);

        ArrayList<Integer> shuffled = new ArrayList<>(integers0);
        Collections.shuffle(shuffled);
        System.out.println("shuffled = " + shuffled);

        boolean isReplaced=Collections.replaceAll(shuffled,1,10);
        System.out.println("shuffled = " + shuffled);
        System.out.println("isReplaced = " + isReplaced);

        Set<String> singleElement = Collections.singleton("Hello world");
        System.out.println(singleElement);
        singleElement.add("test");


    }
}
