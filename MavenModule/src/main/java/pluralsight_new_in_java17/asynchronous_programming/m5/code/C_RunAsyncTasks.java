package pluralsight_new_in_java17.asynchronous_programming.m5.code;

import pluralsight_new_in_java17.asynchronous_programming.common.Quotation;
import pluralsight_new_in_java17.asynchronous_programming.common.QuotationSupplierGenerator;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.Supplier;

public class C_RunAsyncTasks {


    public static void main(String[] args) {
        run();
    }

    public static void run() {


        QuotationSupplierGenerator generator=new QuotationSupplierGenerator();
        List<Supplier<Quotation>> quotationTasks = generator.buildQuotationTasks();

        List<CompletableFuture<Quotation>> futures = new ArrayList<>();
        for (Supplier<Quotation> quotationTask : quotationTasks) {
            var future =
                  CompletableFuture.supplyAsync(quotationTask);
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

        System.out.println("Best quotation = " + bestQuotation);
    }

    private static Quotation openFuture(Future<Quotation> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
