package pluralsight_new_in_java17.asynchronous_programming.m4.code;

import pluralsight_new_in_java17.asynchronous_programming.common.Weather;
import pluralsight_new_in_java17.asynchronous_programming.common.WeatherTaskGenerator;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class B_ReadingOneOfSeveralTasks {



    public static void main(String[] args) throws InterruptedException {
        run();
    }

    public static void run() throws InterruptedException {

        Random random = new Random();

        List<Supplier<Weather>> weatherTasks = WeatherTaskGenerator.buildWeatherTasks(random);

            List<CompletableFuture<Weather>> futures = new ArrayList<>();
            for (Supplier<Weather> task : weatherTasks) {
                CompletableFuture<Weather> future = CompletableFuture.supplyAsync(task);
                futures.add(future);
            }

            CompletableFuture<Object> future =
                  CompletableFuture.anyOf(futures.toArray(CompletableFuture[]::new));

        future.thenAccept(System.out::println).join();
    }


}
