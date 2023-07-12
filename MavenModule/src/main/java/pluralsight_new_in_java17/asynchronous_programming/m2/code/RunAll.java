package pluralsight_new_in_java17.asynchronous_programming.m2.code;

import java.util.concurrent.ExecutionException;

public class RunAll {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        A_RunSynchronousTasks.run();
        B_RunExecutorTasks.run();
        C_RunAsyncTasks.run();
    }
}
