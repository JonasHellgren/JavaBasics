package effective_java.H_Methods.item56;

import effective_java.H_Methods.item50.PeriodInterface;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Set of static methods for dates
 */

public class DateUtils {

    /**
     * Add days, original date plus added days. {@code cal.setTime(..) }  initiates cal object
     * @param date Start date
     * @param days Nof days to add
     * @return   {@link Date}
     * @see <a href=https://www.baeldung.com/javadoc-see-vs-link>Baeldung1</a>
     * @see <a href=https://www.baeldung.com/javadoc>Baeldung2</a>
     *
     */


    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * Calculates nof days in period
     * @param period Interface defined in {@link PeriodInterface}
     * @return   {@link Long}
     * @see PeriodInterface
     *
     */

    public static Long daysBetween(PeriodInterface period)
    {
        Date dateStart=period.getStart();
        Date dateEnd=period.getEnd();
        return TimeUnit.DAYS.convert(dateEnd.getTime() - dateStart.getTime(), TimeUnit.MILLISECONDS);
    }
}
