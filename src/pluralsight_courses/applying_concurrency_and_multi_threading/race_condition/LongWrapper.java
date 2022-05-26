package pluralsight_courses.applying_concurrency_and_multi_threading.race_condition;

import lombok.AllArgsConstructor;
import lombok.Getter;


public class LongWrapper extends LongWrapperAbstract {

    public LongWrapper(long value) {
        super(value);
    }

    public void increment() {
        value=value+1;
    }

}
