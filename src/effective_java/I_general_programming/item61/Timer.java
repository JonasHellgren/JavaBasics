package effective_java.I_general_programming.item61;

import java.util.concurrent.TimeUnit;

/**
 * A simple class for timing short lived events.
 *
 * @author Tristan Waddington
 * https://gist.github.com/twaddington/2633213
 */
public class Timer {
    private long mStart = 0;
    private long mEnd = 0;

    private boolean mRunning = true;

    public Timer(long now) {
        mStart = now;
    }

    /**
     * Start a new {@link Timer}.
     * @return a new Timer object.
     */
    public static Timer createTimer() {
        return new Timer(System.nanoTime());
    }

    @Override
    public String toString() {
        return getElapsedString(TimeUnit.SECONDS);
    }

    /**
     * Get the elapsed runtime in nanoseconds.
     * @return the runtime in nanoseconds.
     */
    public long getElapsed() {
        if (mRunning) {
            return System.nanoTime() - mStart;
        }
        return mEnd - mStart;
    }

    /**
     * Get the elapsed runtime in {@link TimeUnit}.
     *
     * @param unit the desired unit.
     * @return the elapsed runtime converted from nanoseconds to the requested TimeUnit.
     */
    public double getElapsed(TimeUnit unit) {
        double elapsed = -1;

        switch(unit) {
            case SECONDS:
                elapsed = (double) getElapsed() / 1000000000.0;
                break;
            case MILLISECONDS:
                elapsed = (double) getElapsed() / 1000000.0;
                break;
            case NANOSECONDS:
                elapsed = getElapsed();
                break;
        }
        return elapsed;
    }

    /** Stub */
    public String getElapsedString(TimeUnit unit) {
        String u = "";
        switch(unit) {
            case SECONDS:
                u = "s";
                break;
            case MILLISECONDS:
                u = "ms";
                break;
            case NANOSECONDS:
                u = "ns";
                break;
        }
        return String.format("%s%s", getElapsed(unit), u);
    }

    /**
     * Stop the timer and return the elapsed runtime in nanoseconds.
     * @return the Timer object so methods can be chained.
     */
    public Timer end() {
        if (mRunning) {
            mEnd = System.nanoTime();
            mRunning = false;
        }
        return this;
    }


}
