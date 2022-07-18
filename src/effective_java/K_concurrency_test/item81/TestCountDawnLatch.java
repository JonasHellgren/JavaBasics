package effective_java.K_concurrency_test.item81;

import effective_java.K_concurrency.item81.CountDownThread;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//https://www.geeksforgeeks.org/java-util-concurrent-executorservice-interface-with-examples/
public class TestCountDawnLatch {

    /**
     * Starting
     * A: 0
     * B: 0
     * A: 1
     * B: 1
     * B: 2
     * A: 2
     * B: 3
     * A: 3
     * B: 4
     * A: 4
     * C: 0
     * D: 0
     * C: 1
     * C: 2
     * D: 1
     * C: 3
     * D: 2
     * C: 4
     * D: 3
     * D: 4
     * Done
     */

    @Test
    public void countDown()  {

        // Creating objects of CountDownLatch class
        CountDownLatch cd1 = new CountDownLatch(5);
        CountDownLatch cd2 = new CountDownLatch(5);
        CountDownLatch cd3 = new CountDownLatch(5);
        CountDownLatch cd4 = new CountDownLatch(5);

        // Creating objects of ExecutorService class
        ExecutorService es = Executors.newFixedThreadPool(2);

        // Display message only for better readability
        System.out.println("Starting");

        // Executing the tasks
        es.execute(new CountDownThread(cd1, "A"));
        es.execute(new CountDownThread(cd2, "B"));
        es.execute(new CountDownThread(cd3, "C"));
        es.execute(new CountDownThread(cd4, "D"));

        waitThreads(cd1, cd2, cd3, cd4);

        // Making all current executing threads to terminate
        es.shutdown();

        // Display message only for better readability
        System.out.println("Done");
    }

    private void waitThreads(CountDownLatch cd1, CountDownLatch cd2, CountDownLatch cd3, CountDownLatch cd4) {
        // Try block to check for exceptions
        try {

            // Waiting for tasks to complete
            cd1.await();
            cd2.await();
            cd3.await();
            cd4.await();
        }

        // Catch block to handle exceptions
        catch (InterruptedException e) {

            System.out.println(e);
        }
    }

}
