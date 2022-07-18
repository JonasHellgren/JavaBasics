package effective_java.K_concurrency_test.item81;

import org.junit.Test;

import java.util.concurrent.*;

//https://mkyong.com/java/java-executorservice-examples/
public class TestResultFromFuture {

    public static final int N_THREADS = 5;

    /**
     * I'm Runnable task.
     * I'm Callable task.
     * I'm other task! Before Future Result
     * Get future result : 2
     * I'm other task! After Future Result
     */

    @Test
    public void testRunnable() {
        ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
        executor.submit(() -> System.out.println("I'm Runnable task."));  // Runnable, return void, nothing, submit and run the task async

        Future<Integer> futureTask1 = executor.submit(() -> { // Callable, return a future, submit and run the task async
            System.out.println("I'm Callable task.");
            return 1 + 1;
        });

        getFutureResult(executor, futureTask1);
    }

    private void getFutureResult(ExecutorService executor, Future<Integer> futureTask1) {
        try {

            otherTask("Before Future Result");
            Integer result = futureTask1.get(5, TimeUnit.SECONDS); // block until future returned a result, 5 sec timeout
            System.out.println("Get future result : " + result);
            otherTask("After Future Result");

        } catch (InterruptedException | ExecutionException | TimeoutException e) {// thread was interrupted
            e.printStackTrace();
        } finally {
            executor.shutdown(); // shut down the executor manually
        }
    }

    private static void otherTask(String name) {
        System.out.println("I'm other task! " + name);
    }

}
