package benchmark;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkingSleep {
    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void doExection() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException, RunnerException {
        Options opt;
        opt = new OptionsBuilder()
                .include(BenchmarkingSleep.class.getSimpleName())
                .forks(2).warmupIterations(1).measurementIterations(1)
                .build();
        new Runner(opt).run();

    }


}
