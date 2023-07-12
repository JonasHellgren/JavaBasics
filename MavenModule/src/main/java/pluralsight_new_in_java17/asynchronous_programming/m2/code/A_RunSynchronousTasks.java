package pluralsight_new_in_java17.asynchronous_programming.m2.code;

import lombok.extern.java.Log;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;

/**
 * Callable is similar to Runnable, but it can also return a result
 * In this example tasks are executed in sequence
 */

@Log
public class A_RunSynchronousTasks {



    public static void main(String[] args) {
        run();
    }

    public static void run() {
        QuotationCallableGenerator generator=new QuotationCallableGenerator();
        var quotationTasks =
              List.of(generator.quotationA, generator.quotationB, generator.quotationC);

        Instant begin = Instant.now();
        Quotation bestQuotation =
        quotationTasks.stream()
              .map(fetchQ)
              .min(Comparator.comparing(Quotation::amount))
              .orElseThrow();
        Instant end = Instant.now();
        Duration duration = Duration.between(begin, end);
        System.out.println("Best quotation [SYNC ] = " + bestQuotation +
              " (" + duration.toMillis() + "ms)");
    }

    static Function<Callable<Quotation>,Quotation> fetchQ=(t) -> {
        try {
            return t.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    };

}
