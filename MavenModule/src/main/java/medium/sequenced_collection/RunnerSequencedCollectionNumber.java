package medium.sequenced_collection;

import java.util.LinkedList;
import java.util.SequencedCollection;

/***
 * The Sequenced Collections proposal stands out as a game-changing enhancement that promises to redefine how
 * developers interact with collections. This feature injects new interfaces into the existing hierarchy, offering
 * a seamless mechanism to access the first and last elements of a collection using built-in default methods.
 * Moreover, it provides support to obtain a reversed view of the collection.
 */

public class RunnerSequencedCollectionNumber {
    public static void main(String[] args) {
        // Create a new SequencedCollection
        SequencedCollection<Integer> collection = new LinkedList<>();

        // Add some numbers to the collection
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(40);
        collection.add(50);

        System.out.println("collection.getFirst() = " + collection.getFirst());

        // Print the collection
        System.out.println("Initial collection: " + collection);

        // Add an element to the beginning of the collection
        collection.addFirst(5);

        // Print the collection
        System.out.println("Collection after adding 5 to the beginning: " + collection);

        // Add an element to the end of the collection
        collection.addLast(60);

        // Print the collection
        System.out.println("Collection after adding 60 to the end: " + collection);

        // Get the first element of the collection
        Integer firstElement = collection.getFirst();

        // Print the first element
        System.out.println("First element: " + firstElement);

        // Get the last element of the collection
        Integer lastElement = collection.getLast();

        // Print the last element
        System.out.println("Last element: " + lastElement);

        // Remove the first element from the collection
        Integer removedFirstElement = collection.removeFirst();

        // Print the removed first element
        System.out.println("Removed first element: " + removedFirstElement);

        // Print the collection after removing the first element
        System.out.println("Collection after removing the first element: " + collection);

        // Remove the last element from the collection
        Integer removedLastElement = collection.removeLast();

        // Print the removed last element
        System.out.println("Removed last element: " + removedLastElement);

        // Print the collection after removing the last element
        System.out.println("Collection after removing the last element: " + collection);

        // Reverse the collection
        SequencedCollection<Integer> reversedCollection = collection.reversed();

        // Print the reversed collection
        System.out.println("Reversed collection: " + reversedCollection);
    }
}