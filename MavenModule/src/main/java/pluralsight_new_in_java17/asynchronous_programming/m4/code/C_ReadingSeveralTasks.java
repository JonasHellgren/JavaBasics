package pluralsight_new_in_java17.asynchronous_programming.m4.code;

import pluralsight_new_in_java17.asynchronous_programming.common.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

/***
 * If we want to execute two independent Futures and do something with their results, we can use the thenCombine
 * method that accepts a Future and a Function with two arguments to process both results
 *
 * While thenCompose() is used to combine two CompletableFutures where one future is dependent on the other,
 * thenCombine() is used when we want two Futures to run independently and do something after both are complete.
 */

public class C_ReadingSeveralTasks {

    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        Random random = new Random();
        List<Supplier<Weather>> weatherTasks = WeatherTaskGenerator.buildWeatherTasks(random);
        QuotationSupplierGenerator generator=new QuotationSupplierGenerator();
        List<Supplier<Quotation>> quotationTasks = generator.buildQuotationTasks();

        List<CompletableFuture<Weather>> weatherCFs = new ArrayList<>();
        for (Supplier<Weather> task : weatherTasks) {
            CompletableFuture<Weather> future = CompletableFuture.supplyAsync(task);
            weatherCFs.add(future);
        }

        List<CompletableFuture<Quotation>> quotationCFs = new ArrayList<>();
        for (Supplier<Quotation> task : quotationTasks) {
            CompletableFuture<Quotation> future = CompletableFuture.supplyAsync(task);
            quotationCFs.add(future);
        }

        CompletableFuture<Void> allOfQuotations =
              CompletableFuture.allOf(quotationCFs.toArray(CompletableFuture[]::new));

        CompletableFuture<Quotation> bestQuotationCF =
              allOfQuotations.thenApply(
                    v -> quotationCFs.stream()
                          .map(CompletableFuture::join)
                          .min(Comparator.comparing(Quotation::amount))
                          .orElseThrow()
              );


        CompletableFuture<TravelPage> pageCompletableFuture =
              bestQuotationCF.thenCombine(
                    CompletableFuture.anyOf(weatherCFs.toArray(CompletableFuture[]::new))
                          .thenApply(o -> (Weather) o),
                    TravelPage::new
              );
        pageCompletableFuture.thenAccept(System.out::println).join();

        CompletableFuture<TravelPage> pageCompletableFuture2 =
              bestQuotationCF.thenCompose(
                    quotation ->
                          CompletableFuture.anyOf(weatherCFs.toArray(CompletableFuture[]::new))
                                .thenApply(o -> (Weather) o)
                                .thenApply(weather -> new TravelPage(quotation, weather))
              );
        pageCompletableFuture2.thenAccept(System.out::println).join();

    }

}
