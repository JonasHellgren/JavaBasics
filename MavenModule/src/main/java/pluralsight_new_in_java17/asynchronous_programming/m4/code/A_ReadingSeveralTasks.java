package pluralsight_new_in_java17.asynchronous_programming.m4.code;

import pluralsight_new_in_java17.asynchronous_programming.common.Quotation;
import pluralsight_new_in_java17.asynchronous_programming.common.QuotationSupplierGenerator;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/***
 * The CompletableFuture.allOf static method allows to wait for the completion of all the Futures provided as a var-arg
 *
 *  The limitation of this method is that it does not return the combined results of all Futures. Instead, we have to
 *  get results from Futures manually. Fortunately, CompletableFuture.join() method and Java 8 Streams API
 *  makes it simple
 */

public class A_ReadingSeveralTasks {


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        QuotationSupplierGenerator generator = new QuotationSupplierGenerator();
        var quotationTasks =
                List.of(generator.quotationA, generator.quotationB, generator.quotationC);

        List<CompletableFuture<Quotation>> quotationCFS = new ArrayList<>();
        for (Supplier<Quotation> task : quotationTasks) {
            CompletableFuture<Quotation> future = CompletableFuture.supplyAsync(task);
            quotationCFS.add(future);
        }

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(quotationCFS.toArray(CompletableFuture[]::new));

        Quotation bestQuotation =
                allOf.thenApply(
                        v ->
                                quotationCFS.stream()
                                        .map(CompletableFuture::join)
                                        .min(Comparator.comparing(Quotation::amount))
                                        .orElseThrow()
                ).join();
        System.out.println("bestQuotation = " + bestQuotation);
    }

}
