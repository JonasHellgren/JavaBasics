package effective_java.K_concurrency_test.item81;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class TestExecutorService {


    @Test
    //no printing if not run seperately
    public void testRunnable() {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Runnable runnable = () -> System.out.println("I'm Runnable task.");
        executorService.submit(runnable);
        executorService.shutdown();

        /**
         * "I'm Runnable task."
         */
    }

    @Test
    public void testOneFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> "Hello World");
        // some operations
        String result = future.get();
        System.out.println("result = " + result);
        executorService.shutdown();

        /**
         * result = Hello World
         */
    }

    @Test
    public void testCallable() throws InterruptedException, ExecutionException {
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Set<Callable<String>> callables = new HashSet<>();
        callables.add(() -> "Task 1");
        callables.add(() -> "Task 2");
        callables.add(() -> "Task 3");

        List<Future<String>> futures = executorService.invokeAll(callables);

        for(Future<String> future : futures){
            System.out.println("future.get = " + future.get());
        }

        executorService.shutdown();

        /**
         * future.get = Task 3
         * future.get = Task 1
         * future.get = Task 2
         */

    }


    @Test
    public void testScheduled() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
        executor.schedule(() -> {
            System.out.println("Hello World");
        }, 500, TimeUnit.MILLISECONDS);
        executor.shutdown();
    }

}