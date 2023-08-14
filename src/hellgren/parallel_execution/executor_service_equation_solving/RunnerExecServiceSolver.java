package hellgren.parallel_execution.executor_service_equation_solving;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.function.Function;

public class RunnerExecServiceSolver {

    public static final int MAX_TIME_IN_MILLIS = 10;
    public static final int NOF_TASKS = 10;
    public static final int NOF_THREADS = 10;

    public static void main(String[] args) throws InterruptedException {
        Function<Double,Double> function=(x) -> 4*x-2;

        Set<Callable<SolverCallable.XYPair>> tasks = createTasks(function);
        ExecutorService executorService = Executors.newFixedThreadPool(NOF_THREADS);
        List<SolverCallable.XYPair> resultList = getTaskResults(tasks, executorService);
        resultList.forEach(System.out::println);
        executorService.shutdown();

    }

    private static Set<Callable<SolverCallable.XYPair>> createTasks(Function<Double, Double> function) {
        Set<Callable<SolverCallable.XYPair>> tasks = new HashSet<>();
        for (int i = 0; i < NOF_TASKS; i++) {
            tasks.add(new SolverCallable(function, MAX_TIME_IN_MILLIS));
        }
        return tasks;
    }

    private static List<SolverCallable.XYPair> getTaskResults(Set<Callable<SolverCallable.XYPair>> tasks, ExecutorService executorService) throws InterruptedException {
        List<Future<SolverCallable.XYPair>> futures = executorService.invokeAll(tasks);
        List<SolverCallable.XYPair> resultList=new ArrayList<>();
        for(Future<SolverCallable.XYPair> future : futures){
            try {
                resultList.add(future.get());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        return resultList;
    }


}
