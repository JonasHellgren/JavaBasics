package effective_java.F_enums_and_annotaitons_tests.item37;

import effective_java.F_enums_and_annotaitons.item37.DayOfWeek;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EnumMap;

public class TestDayOfFWeek {

    EnumMap<DayOfWeek,String> activityMap;

    @Before
    public void createMap() {
        activityMap=new EnumMap<>(DayOfWeek.class);
        activityMap.put(DayOfWeek.MONDAY,"Gymnastics");
        //activityMap.put(DayOfWeek.MONDAY,"Gymnastics2");  //replaces Gymnastics
        activityMap.put(DayOfWeek.SATURDAY,"Football");
        activityMap.put(DayOfWeek.SUNDAY,"ThaiBox");
    }

    @Test
    public void testCreateActiveMap() {
        System.out.println("activityMap = " + activityMap);
        Assert.assertEquals(3,activityMap.size());
    }

    @Test
    public void testGet() {
        System.out.println("activityMap = " + activityMap);
        Assert.assertEquals("Football",activityMap.get(DayOfWeek.SATURDAY));
    }


}
