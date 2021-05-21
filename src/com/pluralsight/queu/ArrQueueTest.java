package com.pluralsight.queu;
import java.util.ArrayDeque;

public class ArrQueueTest {
    static public void runtest(ArrayDeque animals) {
        System.out.println("1st ArrayDeque: " + animals);
        animals.offerFirst("Bird");
        System.out.println("2nd ArrayDeque: " + animals);
        System.out.println("First Element: " + animals.peekFirst());  //first element of the array deque
        System.out.println("Last Element: " + animals.peekLast());  //last element of the array deque
        System.out.println("Does ArrayDeque include Bird?: " + animals.contains("Bird"));
    }
}
