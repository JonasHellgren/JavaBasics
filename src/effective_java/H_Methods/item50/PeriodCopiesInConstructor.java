package effective_java.H_Methods.item50;

import lombok.Getter;
import java.util.Date;

@Getter
public class PeriodCopiesInConstructor implements PeriodInterface {

    private final Date start;
    private final Date end;

    public PeriodCopiesInConstructor(Date start, Date end) {
        assert start.before(end);

        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

}
