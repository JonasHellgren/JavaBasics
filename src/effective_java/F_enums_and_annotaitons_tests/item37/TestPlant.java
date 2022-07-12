package effective_java.F_enums_and_annotaitons_tests.item37;

import effective_java.F_enums_and_annotaitons.item37.Plant;
import org.junit.Test;

import java.util.*;

public class TestPlant {

    @Test
    public void testPlant() {

        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        List<Plant> garden=new ArrayList<>();
        garden.add(new Plant("Ek",Plant.LifeCycle.PERENNIAL));
        garden.add(new Plant("Ros",Plant.LifeCycle.ANNUAL));

        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant p : garden) {
            plantsByLifeCycle.get(p.getLifeCycle()).add(p);
        }

        System.out.println(plantsByLifeCycle);

    }

}
