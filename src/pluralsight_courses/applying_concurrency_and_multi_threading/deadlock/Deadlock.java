package pluralsight_courses.applying_concurrency_and_multi_threading.deadlock;

/**
 * Thread 2 should call method c, but never happens because this needs key1 that is taken by thread 1
 */

public class Deadlock {

    public static void main(String[] args) throws InterruptedException {
        TwoKeysThreeMethods twoKeysThreeMethods=new TwoKeysThreeMethods();

        Runnable r1 = () -> twoKeysThreeMethods.a();
        Runnable r2 = () -> twoKeysThreeMethods.b();

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
