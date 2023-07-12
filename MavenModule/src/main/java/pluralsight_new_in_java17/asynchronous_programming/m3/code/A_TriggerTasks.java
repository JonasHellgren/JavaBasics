package pluralsight_new_in_java17.asynchronous_programming.m3.code;

import pluralsight_new_in_java17.asynchronous_programming.common.Quotation;
import pluralsight_new_in_java17.asynchronous_programming.common.QuotationSupplierGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.function.Supplier;

/**
 The thenAccept method receives a Consumer and passes it the result of the computation. Then the final future.get()
 call returns an instance of the Void type
 */

public class A_TriggerTasks {


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        QuotationSupplierGenerator generator=new QuotationSupplierGenerator();
        var quotationTasks =
                List.of(generator.quotationA, generator.quotationB, generator.quotationC);

        Instant begin = Instant.now();

        List<CompletableFuture<Quotation>> futures = new ArrayList<>();
        for (Supplier<Quotation> task : quotationTasks) {
            CompletableFuture<Quotation> future =
                  CompletableFuture.supplyAsync(task);
            futures.add(future);
        }

        Collection<Quotation> quotations = new ConcurrentLinkedDeque<>();
        List<CompletableFuture<Void>> voids = new ArrayList<>();
        for (CompletableFuture<Quotation> future : futures) {
            future.thenAccept(System.out::println);
            CompletableFuture<Void> accept =
                  future.thenAccept(quotations::add);  //consumer
            voids.add(accept);
        }

        for (CompletableFuture<Void> v : voids) {
            v.join();   //completing tasks
        }

        System.out.println("quotations = " + quotations);


        Quotation bestQuotation =
              quotations.stream()
                    .min(Comparator.comparing(Quotation::amount))
                    .orElseThrow();

        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        System.out.println("Best quotation [ASYNC] = " + bestQuotation +
              " (" + duration.toMillis() + "ms)");
    }
}
