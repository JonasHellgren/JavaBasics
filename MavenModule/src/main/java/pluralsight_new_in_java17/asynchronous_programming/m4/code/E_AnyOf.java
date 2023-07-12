package pluralsight_new_in_java17.asynchronous_programming.m4.code;

import pluralsight_new_in_java17.asynchronous_programming.common.Weather;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class E_AnyOf {


    public static void main(String[] args) {

        Supplier<Weather> fetchWeatherA =
              () -> {
                  try {
                      Thread.sleep(11);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  return new Weather("Server A", "Sunny");
              };
        Supplier<Weather> fetchWeatherB =
              () -> {
                  try {
                      Thread.sleep(10);
                  } catch (InterruptedException e) {
                      throw new RuntimeException(e);
                  }
                  return new Weather("Server B", "Mostly Sunny");
              };

        CompletableFuture<Weather> taskA =
              CompletableFuture.supplyAsync(fetchWeatherA);
        CompletableFuture<Weather> taskB =
              CompletableFuture.supplyAsync(fetchWeatherB);

        CompletableFuture.anyOf(taskA, taskB)
              .thenAccept(System.out::println)
              .join();

        System.out.println("taskA = " + taskA);
        System.out.println("taskB = " + taskB);
    }
}
