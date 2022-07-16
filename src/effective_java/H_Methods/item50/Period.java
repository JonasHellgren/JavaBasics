package effective_java.H_Methods.item50;

import lombok.Getter;

import java.util.Date;

@Getter
public final class Period implements PeriodInterface{

    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        assert start.before(end);

        this.start = start;
        this.end = end;
    }
}
