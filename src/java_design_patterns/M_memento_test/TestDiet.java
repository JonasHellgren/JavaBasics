package java_design_patterns.M_memento_test;

import java_design_patterns.M_memento.diet.DietInfo;
import java_design_patterns.M_memento.diet.DietInfoBackup;
import org.junit.Assert;
import org.junit.Test;

public class TestDiet {

    @Test
    public void test() {
        DietInfoBackup backup = new DietInfoBackup();
        DietInfo dietInfo = new DietInfo("Fred", 1, 100);

        dietInfo.setDayNumberAndWeight(2, 99);
        System.out.println("Saving state.");
        backup.saveState(dietInfo);
        dietInfo.setDayNumberAndWeight(3, 98);
        dietInfo.setDayNumberAndWeight(4, 97);
        System.out.println("Restoring saved state.");
        Assert.assertEquals(4,dietInfo.getDayNumber());
        backup.restoreState(dietInfo);
        Assert.assertEquals(2,dietInfo.getDayNumber());

    }

}
