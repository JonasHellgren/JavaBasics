package pluralsight_courses.applying_concurrency_and_multi_threading.race_condition;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public  abstract class LongWrapperAbstract {
    protected long value;

    public abstract void increment();
}
