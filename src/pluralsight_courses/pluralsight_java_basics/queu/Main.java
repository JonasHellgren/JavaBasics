package pluralsight_courses.pluralsight_java_basics.queu;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Queue<Integer> numbers = new LinkedList<>();  // Creating Queue using the LinkedList class
        numbers.offer(1);    numbers.offer(2);     numbers.offer(3); // offer elements to the Queue
        QueueTest.runtest(numbers);
        System.out.println("Updated Queue (main): " + numbers);  //Show Updated Queue

        Queue<Integer> numbersprio = new PriorityQueue<>();  //Creating PriorityQueue, head is the smallest element
        numbersprio.offer(4);     //4 inserted first
        numbersprio.offer(2);     //2 inserted then, rearranged for smallest element to the head
        PrioQueueTest.runtest(numbersprio);

        ArrayDeque<String> animals= new ArrayDeque<>();  //Creating ArrayDeque, Double Ended Queue
        animals.add("Dog");     animals.add("Cat");     animals.add("Horse");
        ArrQueueTest.runtest(animals);
    }
}
