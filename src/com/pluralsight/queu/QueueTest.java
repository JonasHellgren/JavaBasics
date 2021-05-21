package com.pluralsight.queu;
import java.util.Queue;

public class QueueTest {
    static public void runtest(Queue queue) {
        System.out.println("Original Queue: " + queue);
        System.out.println("Head Element: " + queue.peek());  //Show head of the queue
        System.out.println("Removed Element: " + queue.poll());  // Remove head element
  }
}
