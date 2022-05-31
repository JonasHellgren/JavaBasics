package pluralsight_courses.applying_concurrency_and_multi_threading.worker;

import java.util.Timer;
import java.util.TimerTask;

/***
 * Will print "Still working" for ever if not code is blocked by lock
 * Lock avoid race condition of variable quittingTime
 */

public class Worker extends Thread {

    public static final int DELAY_AT_WHICH_KEEP_WORKING_SHALL_BE_CALLED = 500;
    public static final int SLEEP_TIME_MAIN_THREAD = 400;
    public static final int SLEEP_TIME_WORK_THREAD = 300;
    private Object lock=new Object();
    private volatile boolean quittingTime = false;

    public void run() {
        while (!quittingTime) {
            working();
            System.out.println("Still working");
            System.out.println("quittingTime = " + quittingTime);
        }
        System.out.println("Coffee is good");
    }

    private void working() {
        try {
            Thread.sleep(SLEEP_TIME_WORK_THREAD);
        } catch (InterruptedException e) {
        }
    }

    private void keepWorking() {
        synchronized (lock) {
            quittingTime=false;
            System.out.println("Keep working");
        }
    }

    synchronized void quit() throws InterruptedException {
        synchronized (lock) {
            quittingTime = true;
            System.out.println("quittingTime = " + quittingTime);
            System.out.println("Calling join");
            join();
            System.out.println("Back from join");
       }
    }

    public static void main(String[] args) throws InterruptedException {
        final Worker worker = new Worker();
        worker.start();
        createScheduledTask(worker);
        Thread.sleep(SLEEP_TIME_MAIN_THREAD);
        worker.quit();
    }

    private static void createScheduledTask(Worker worker) {
        Timer t = new Timer(true);  //Daemon thread
        System.out.println("createScheduledTask");
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        }, DELAY_AT_WHICH_KEEP_WORKING_SHALL_BE_CALLED);
    }
}
