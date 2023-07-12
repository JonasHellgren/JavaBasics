package pluralsight_new_in_java17.asynchronous_programming.m2.code;

import java.sql.Array;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

/***
 * The Future interface was added in Java 5 to serve as a result of an asynchronous computation, but it did not have
 * any methods to combine these computations or handle possible errors.
 *
 * Java 8 introduced the CompletableFuture class. Along with the Future interface, it also implemented the
 * CompletionStage interface. This interface defines the contract for an asynchronous computation step that we
 * can combine with other steps.
 *
 * CompletableFuture is at the same time, a building block and a framework, with about 50 different methods for
 * composing, combining, and executing asynchronous computation steps and handling errors.
 */

public class C_RunAsyncTasks {


    public static void main(String[] args) {
        run();
    }

    public static void run() {

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

        List<Quotation> quotations = new ArrayList<>();
        for (CompletableFuture<Quotation> future : futures) {
            Quotation quotation = future.join();
            quotations.add(quotation);
        }

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
