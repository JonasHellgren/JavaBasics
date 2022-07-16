package effective_java.H_Methods.item50;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {

    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static Long daysBetween(PeriodInterface period)
    {
        Date dateStart=period.getStart();
        Date dateEnd=period.getEnd();
        return TimeUnit.DAYS.convert(dateEnd.getTime() - dateStart.getTime(), TimeUnit.MILLISECONDS);
    }
}
