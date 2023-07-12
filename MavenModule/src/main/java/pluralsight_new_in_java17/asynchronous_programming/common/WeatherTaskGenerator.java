package pluralsight_new_in_java17.asynchronous_programming.common;

import pluralsight_new_in_java17.asynchronous_programming.m4.code.B_ReadingOneOfSeveralTasks;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class WeatherTaskGenerator {
        public static List<Supplier<Weather>> buildWeatherTasks(Random random) {
            Supplier<Weather> fetchWeatherA =
                    () -> {
                        try {
                            Thread.sleep(random.nextInt(80, 120));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
//                  System.out.println("A running in " + Thread.currentThread());
                        return new Weather("Server A", "Sunny");
                    };
            Supplier<Weather> fetchWeatherB =
                    () -> {
                        try {
                            Thread.sleep(random.nextInt(80, 120));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
//                  System.out.println("B running in " + Thread.currentThread());
                        return new Weather("Server B", "Mostly Sunny");
                    };
            Supplier<Weather> fetchWeatherC =
                    () -> {
                        try {
                            Thread.sleep(random.nextInt(80, 120));
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
//                  System.out.println("C running in " + Thread.currentThread());
                        return new Weather("Server C", "Almost Sunny");
                    };

            var weatherTasks =
                    List.of(fetchWeatherA, fetchWeatherB, fetchWeatherC);
            return weatherTasks;
        }
}
