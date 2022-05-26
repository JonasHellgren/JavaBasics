package pluralsight_courses.applying_concurrency_and_multi_threading.race_condition;

public class LongWrapperSynchronized extends LongWrapperAbstract  {

    private final Object key=new Object();

    public LongWrapperSynchronized(long value) {
        super(value);
    }

    public void increment() {
        synchronized (key) {
            value = value + 1;
        }
    }
}
