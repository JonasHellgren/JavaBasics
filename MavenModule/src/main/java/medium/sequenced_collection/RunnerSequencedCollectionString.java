package medium.sequenced_collection;

import java.util.LinkedList;
import java.util.SequencedCollection;

public class RunnerSequencedCollectionString {

    public static void main(String[] args) {
        SequencedCollection<String> names = new LinkedList<>();

        // Add elements to the collection
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // Forward iteration
        System.out.println("Forward order:");
        for (String name : names) {
            System.out.println(name);
        }

        // Reverse iteration
        System.out.println("\nReverse order:");
        for (String name : names.reversed()) {
            System.out.println(name);
        }

        // Accessing the first and last elements
        System.out.println("\nFirst element: " + names.getFirst());
        System.out.println("Last element: " + names.getLast());
    }

}
