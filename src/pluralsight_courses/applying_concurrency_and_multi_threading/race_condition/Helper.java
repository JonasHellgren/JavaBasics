package pluralsight_courses.applying_concurrency_and_multi_threading.race_condition;

public class Helper {


    protected static Runnable createRunnable(LongWrapperAbstract longWrapper, double NOF_INCREMENT_PER_THREAD) {
        return () -> {
            for (int i = 0; i < NOF_INCREMENT_PER_THREAD; i++) {
                longWrapper.increment();
            }
        };
    }

    protected static void joinThreads(Thread[] threads) throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
    }

    protected static void startThreads(Thread[] threads) {
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
    }

    protected static void createThreads(Runnable r, Thread[] threads) {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
        }
    }

}
