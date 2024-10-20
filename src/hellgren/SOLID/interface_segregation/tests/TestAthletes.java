package hellgren.SOLID.interface_segregation.tests;

import hellgren.SOLID.interface_segregation.classes.*;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class TestAthletes {

    @Test
    public void testSwimmer() {
        SwimmerInterface s=new Swimmer("Steve");
        s.compete();
        s.swim();
    }

    @Test public void testRunner() {
        RunnerInterface r=new Runner("Ben");
        r.compete();
        //r.swim();  not possible
        r.run();
    }

    @Test public void testListWithAthleteInterface() {
        List<AthleteInterface> athletes=new ArrayList<>();
        athletes.add(new Swimmer("Steve"));
        athletes.add(new Runner("Ben"));
        athletes.forEach(AthleteInterface::compete);
    }

    @Test public void athleteIsSwimmmer() {
        AthleteInterface s=new Swimmer("Steve");
        printSwimmer(s);
        Assertions.assertTrue(s instanceof SwimmerInterface);
    }

    @Test public void athleteIsRunner() {
        AthleteInterface r=new Runner("Ben");
       // printSwimmer(r);  ClassCastException
    }

    private void printSwimmer(AthleteInterface a) {
        a.compete();
        SwimmerInterface s=(SwimmerInterface) a;
        s.swim();
    }

}
