package hellgren.parallel_execution.educative;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static java.lang.System.out;

/**
 *
 https://www.educative.io/answers/how-to-run-all-tasks-of-collection-with-executorservice-in-java
 */


public class SleepTasks {

    private static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            out.println(e.getMessage());
        }
    }

    private static String algoOne(){
        out.println("Starting algorithm one");
        sleep(1000);
        out.println("Finished algorithm one");

        return "algoOne Result";
    }

    private static String algoTwo(){
        out.println("Starting algorithm two");
        sleep(100);
        out.println("Finished algorithm two");
        return "algoTwo Result";
    }

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Future<String>> taskFutures = executorService.invokeAll(Arrays.asList(SleepTasks::algoOne, SleepTasks::algoTwo));
        out.println("invokeAll finished");
        taskFutures.forEach(res -> {
            try {
                out.println("Result - " + res.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }
}
