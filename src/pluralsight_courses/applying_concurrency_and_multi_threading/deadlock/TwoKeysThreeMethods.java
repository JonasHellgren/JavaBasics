package pluralsight_courses.applying_concurrency_and_multi_threading.deadlock;

public class TwoKeysThreeMethods {

    private final Object key1=new Object();
    private final Object key2=new Object();

    public void a() {
        synchronized (key1) {
            print(Thread.currentThread().getName(),"a");
            b();
        }
    }

    public void b() {
        synchronized (key2) {
            print(Thread.currentThread().getName(),"b");
            c();
        }
    }

    public void c() {
        synchronized (key1) {
            print(Thread.currentThread().getName(),"c");
        }
    }

    private void print(String threadName, String methodName ) {
        System.out.println("["+threadName+"]"+" I am in "+methodName);
    }


}
