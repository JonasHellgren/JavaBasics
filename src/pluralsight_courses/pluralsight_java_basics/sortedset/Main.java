package pluralsight_courses.pluralsight_java_basics.sortedset;

import java.util.SortedSet;
import java.util.TreeSet;

class Main {

    public static void main(String[] args) {
        SortedSet<Integer> numbers = new TreeSet<>();  // Creating SortedSet using the TreeSet

        // Insert elements to the set, and print set
        numbers.add(7);     numbers.add(2);     numbers.add(3);      numbers.add(4);
        System.out.println("SortedSet: " + numbers);

        // Access the element, and print
        int firstNumber = numbers.first();
        System.out.println("First Number: " + firstNumber);

    }
}