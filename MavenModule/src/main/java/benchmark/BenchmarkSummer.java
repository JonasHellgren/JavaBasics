package benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static benchmark.Summer.sumArray;
import static benchmark.Summer.sumList;

@State(Scope.Thread)
public  class BenchmarkSummer {
    public static final int LENGTH = (int) 10e6;
    int[] array;
    List<Integer> list;

    @Setup
    public void prepare() {
        array = new int[LENGTH];
        list = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            array[i] = i;
            list.add(i);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testSumArray(BenchmarkSummer state) {
        sumArray(state.array);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testSumList(BenchmarkSummer state) {
        sumList(Arrays.stream(state.array).boxed().toList());
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void testSumListNoConversion(BenchmarkSummer state) {
        sumList(state.list);
    }


    public static void main(String[] args) throws RunnerException {
        Options opt;
        opt = new OptionsBuilder()
                .include(BenchmarkSummer.class.getSimpleName())
                .forks(1).warmupIterations(1).measurementIterations(1)
                .measurementTime(TimeValue.milliseconds(100))
                .build();
        new Runner(opt).run();

    }

}
