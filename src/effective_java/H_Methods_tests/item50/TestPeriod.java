package effective_java.H_Methods_tests.item50;

import effective_java.H_Methods.item50.DateUtils;
import effective_java.H_Methods.item50.Period;
import effective_java.H_Methods.item50.PeriodCopiesInConstructor;
import effective_java.H_Methods.item50.PeriodInterface;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestPeriod {


    @Test
    public void testPeriodCanBeModified() {

        Date start=new Date();
        Date end=new Date();
        end = DateUtils.addDays(end, 1);
        Period period=new Period(start,end);
        end.setTime(end.getTime()+Integer.MAX_VALUE);  //corrupted despite "immutable"

        System.out.println("days in period = " + DateUtils.daysBetween(period));
        Assert.assertNotEquals(1,DateUtils.daysBetween(period).longValue());
    }


    @Test
    public void testPeriodCopiesInConstructorCannotBeModified() {

        Date start=new Date();
        Date end=new Date();
        end = DateUtils.addDays(end, 1);
        PeriodCopiesInConstructor period=new PeriodCopiesInConstructor(start,end);
        end.setTime(end.getTime()+Integer.MAX_VALUE);  //not corrupted thanks to defencive copy

        System.out.println("days in period = " + DateUtils.daysBetween(period));
        Assert.assertEquals(1,DateUtils.daysBetween(period).longValue());
    }





}
