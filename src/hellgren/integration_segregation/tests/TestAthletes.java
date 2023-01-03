package hellgren.integration_segregation.tests;

import hellgren.integration_segregation.classes.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAthletes {

    @Test
    public void testSwimmer() {
        SwimmerInterface s=new Swimmer();
        s.compete();
        s.swim();
    }

    @Test public void testRunner() {
        RunnerInterface r=new Runner();
        r.compete();
        //r.swim();  not possible
        r.run();
    }

    @Test public void testListWithAthleteInterface() {
        List<AthleteInterface> athletes=new ArrayList<>();
        athletes.add(new Swimmer());
        athletes.add(new Runner());
        athletes.forEach(AthleteInterface::compete);
    }

}
