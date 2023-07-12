package pluralsight_new_in_java17.asynchronous_programming.m6.code;

import pluralsight_new_in_java17.asynchronous_programming.common.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class E_ComposingTasks {


    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        Random random = new Random();
        List<Supplier<Weather>> weatherTasks = WeatherTaskGenerator.buildWeatherTasks(random);
        QuotationSupplierGenerator generator = new QuotationSupplierGenerator();
        List<Supplier<Quotation>> quotationTasks = generator.buildQuotationTasks();

        List<CompletableFuture<Weather>> weatherCFs = new ArrayList<>();
        for (Supplier<Weather> weatherTask : weatherTasks) {
            CompletableFuture<Weather> weatherCF =
                    CompletableFuture.supplyAsync(weatherTask)
                            .exceptionally(e -> {
                                System.out.println("e = " + e);
                                return new Weather("Unknown", "Unknown");
                            });
            weatherCFs.add(weatherCF);
        }

        CompletableFuture<Weather> anyOfWeather =
                CompletableFuture
                        .anyOf(weatherCFs.toArray(CompletableFuture[]::new))
                        .thenApply(weather -> (Weather) weather);


        List<CompletableFuture<Quotation>> quotationCFs = new ArrayList<>();
        for (Supplier<Quotation> quotationTask : quotationTasks) {
            CompletableFuture<Quotation> quotationCF =
                    CompletableFuture
                            .supplyAsync(quotationTask)
                            .handle(
                                    (quotation, exception) -> {
                                        if (exception == null) {
                                            return quotation;
                                        } else {
                                            System.out.println("exception = " + exception);
                                            return new Quotation("Unknown", 1_000);
                                        }
                                    }
                            );
            quotationCFs.add(quotationCF);
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

        CompletableFuture<Void> done =
                bestQuotationCF.thenCompose(
                                quotation ->
                                        anyOfWeather.thenApply(
                                                weather -> new TravelPage(quotation, weather)))
                        .thenAccept(System.out::println);
        done.join();
    }

}
