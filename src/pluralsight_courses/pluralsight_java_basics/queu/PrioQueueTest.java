package pluralsight_courses.pluralsight_java_basics.queu;
import java.util.Queue;

public class PrioQueueTest {
    static public void runtest(Queue queue) {
        System.out.println("1st prio Queue: " + queue);
        queue.offer(1);  //rearranged to store the smallest element to the head
        System.out.println("2nd prio Queue: " + queue);
    }
}
