package pluralsight_new_in_java17.asynchronous_programming.m2.code;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Thanks to Future and ThreadPool executor tasks can be run in parallel
 */

public class B_RunExecutorTasks {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        run();
    }

    public static void run() throws ExecutionException, InterruptedException {
        QuotationCallableGenerator generator=new QuotationCallableGenerator();
        var quotationTasks =
                List.of(generator.quotationA, generator.quotationB, generator.quotationC);

        var executor = Executors.newFixedThreadPool(4);
        Instant begin = Instant.now();

        List<Future<Quotation>> futures = new ArrayList<>();
        for (Callable<Quotation> task : quotationTasks) {
            Future<Quotation> future = executor.submit(task);  //blocks non-main thread, main continuous
            futures.add(future);
        }

        List<Quotation> quotations = new ArrayList<>();
        for (Future<Quotation> future : futures) {
            Quotation quotation = future.get();   //response of result in achieved in non main thread
            quotations.add(quotation);
        }

        Quotation bestQuotation =
        quotations.stream()
              .min(Comparator.comparing(Quotation::amount))
              .orElseThrow();

        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        System.out.println("Best quotation [ES   ] = " + bestQuotation +
              " (" + duration.toMillis() + "ms)");

        executor.shutdown();
    }

    private static Quotation openFuture(Future<Quotation> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static Quotation fetchQuotation(Callable<Quotation> task) {
        try {
            return task.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
