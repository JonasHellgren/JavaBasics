package pluralsight_courses.applying_concurrency_and_multi_threading.race_condition;

import lombok.SneakyThrows;

/**
 * Due to race condition, threads write and writes at same memory, value will
 * not be NOF_INCREMENT_PER_THREAD*NOF_THREADS
 *
 * Fixed by synchronized (key) in longWrapperSynchronized
 */

public class App {

    public static final int NOF_INCREMENT_PER_THREAD = 10000;
    public static final int NOF_THREADS = 100;

    @SneakyThrows
    public static void main(String[] args) {
        LongWrapperAbstract longWrapper = new LongWrapper(0);
        Runnable r = Helper.createRunnable(longWrapper,NOF_INCREMENT_PER_THREAD);
        Thread[] threads = new Thread[NOF_THREADS];
        Helper.createThreads(r, threads);
        Helper.startThreads(threads);
        Helper.joinThreads(threads);
        System.out.println("Value = " + longWrapper.getValue());

        LongWrapperAbstract longWrapperSynchronized = new LongWrapperSynchronized(0);
        Runnable rSync = Helper.createRunnable(longWrapperSynchronized,NOF_INCREMENT_PER_THREAD);
        Helper.createThreads(rSync, threads);
        Helper.startThreads(threads);
        Helper.joinThreads(threads);
        System.out.println("Value synced = " + longWrapperSynchronized.getValue());


    }


}


