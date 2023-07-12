package pluralsight_new_in_java17.asynchronous_programming.m4.code;

import pluralsight_new_in_java17.asynchronous_programming.common.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class D_ComposingTasks {


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        Random random = new Random();

        List<Supplier<Weather>> weatherTasks = WeatherTaskGenerator.buildWeatherTasks(random);
        QuotationSupplierGenerator generator=new QuotationSupplierGenerator();
        List<Supplier<Quotation>> quotationTasks = generator.buildQuotationTasks();

        CompletableFuture<Weather>[] weatherCFs = weatherTasks.stream()
              .map(CompletableFuture::supplyAsync)
              .toArray(CompletableFuture[]::new);

        CompletableFuture<Weather> weatherCF =
              CompletableFuture.anyOf(weatherCFs)
                    .thenApply(weather -> (Weather) weather);


        CompletableFuture<Quotation>[] quotationCFS = quotationTasks.stream()
              .map(CompletableFuture::supplyAsync)
              .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> allOf = CompletableFuture.allOf(quotationCFS);

        CompletableFuture<Quotation> bestQuotationCF = allOf.thenApply(
              v -> Arrays.stream(quotationCFS)
                    .map(CompletableFuture::join)
                    .min(Comparator.comparing(Quotation::amount))
                    .orElseThrow()
        );

        CompletableFuture<Void> done =
        bestQuotationCF.thenCompose(
              quotation ->
                    weatherCF.thenApply(weather -> new TravelPage(quotation, weather)))
              .thenAccept(System.out::println);
        done.join();
    }


}
