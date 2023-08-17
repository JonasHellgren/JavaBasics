package hellgren.parallel_execution.executor_service_equation_solving;

import common.CpuTimer;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Log
public class RunnerExecServiceSolver {

    public static final int MAX_TIME_IN_MILLIS = 1000;
    public static final int NOF_TASKS = 5;

    public static void main(String[] args) throws InterruptedException {
        int nofCores = Runtime.getRuntime().availableProcessors();
        log.info("nofCores = " + nofCores);
        List<SolverCallable> tasks = createTasks();
        ExecutorService executorService = Executors.newFixedThreadPool(nofCores);
        CpuTimer timer = new CpuTimer();
        List<SolverCallable.XYPair> resultList = getTaskResults(tasks, executorService);
        System.out.println("timer = " + timer);
        resultList.forEach(System.out::println);
        executorService.shutdown();

    }

    private static List<SolverCallable> createTasks() {
        List<SolverCallable> tasks = new ArrayList<>();
        for (int i = 0; i < NOF_TASKS; i++) {
            tasks.add(new SolverCallable(MAX_TIME_IN_MILLIS));
        }
        return tasks;
    }

    private static List<SolverCallable.XYPair> getTaskResults(List<SolverCallable> tasks, ExecutorService es)
            throws InterruptedException {
        List<Future<SolverCallable.XYPair>> futures = es.invokeAll(tasks);
        log.info("invokeAll finished");
        return futures.stream().map(f -> {
            try {
                return f.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).toList();
    }

    public static void awaitTerminationAfterShutdown(ExecutorService threadPool) {
        threadPool.shutdown();
        try {
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException ex) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }


    }

}
