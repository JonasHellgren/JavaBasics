package hellgren.parallel_execution.executor_service_equation_solving;

import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Function;

@Log
public class RunnerExecServiceSolver {

    public static final int MAX_TIME_IN_MILLIS = 10;
    public static final int NOF_TASKS = 5;

    public static void main(String[] args) throws InterruptedException {
        Function<Double,Double> function=(x) -> 4*x-2;

        int nofCores=Runtime.getRuntime().availableProcessors();
        log.info("nofCores = "+nofCores);
        Set<Callable<SolverCallable>> tasks = createTasks(function, NOF_TASKS);
        ExecutorService executorService = Executors.newFixedThreadPool(nofCores);
        List<SolverCallable.XYPair> resultList = getTaskResults(tasks, executorService);
        resultList.forEach(System.out::println);
        executorService.shutdown();

    }

    private static Set<Callable<SolverCallable>> createTasks(Function<Double, Double> function, int nofTasks) {
        Set<Callable<SolverCallable>> tasks = new HashSet<>();
        for (int i = 0; i < nofTasks; i++) {
            tasks.add(() -> new SolverCallable(function, MAX_TIME_IN_MILLIS));
        }
        return tasks;
    }

    private static List<SolverCallable.XYPair> getTaskResults(Set<Callable<SolverCallable>> tasks, ExecutorService executorService) throws InterruptedException {
        List<Future<SolverCallable>> futures = executorService.invokeAll(tasks);
        List<SolverCallable.XYPair> resultList=new ArrayList<>();
        for(Future<SolverCallable> future : futures){
            try {
                resultList.add(future.get().call());
            } catch (Exception e) {
                log.severe("Serious problem");
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }


}
