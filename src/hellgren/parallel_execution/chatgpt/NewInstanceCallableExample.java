package hellgren.parallel_execution.chatgpt;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

import static java.lang.System.out;

class MyCallable implements Callable<Integer> {

    Random random = new Random();

    @Override
    public Integer call() throws Exception {
        out.println("Before tasks starts");
        Thread.sleep(1000);
        out.println("Task finished");
        return random.nextInt();
    }
}

@Log
public class NewInstanceCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(4); // Create an ExecutorService
        List<MyCallable> tasks = new ArrayList<>(); // Create a list to hold tasks

        // Create new instances of MyCallable and add them to the list
        for (int i = 0; i < 5; i++) {
            tasks.add(new MyCallable());
        }
        // Submit tasks from the list to the ExecutorService
        List<Future<Integer>> futures = executor.invokeAll(tasks);
        out.println("After invokeAll");
        // Wait for tasks to complete and retrieve results

        futures.forEach(f -> {
            try {
                out.println("Result: " + f.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        // Shutdown the ExecutorService
        executor.shutdown();
    }


}
