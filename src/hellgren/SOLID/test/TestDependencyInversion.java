package hellgren.SOLID.test;

import hellgren.SOLID.dependency_inversion.BackEndDeveloper;
import hellgren.SOLID.dependency_inversion.Developer;
import hellgren.SOLID.dependency_inversion.FrontEndDeveloper;
import hellgren.SOLID.dependency_inversion.Project;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * The Project class does not depend on lower level modules but abstractions.
 * Also low-level modules and their details depend on abstractions.
 */

public class TestDependencyInversion {

    @Test
    public void whenMixedDevelopers_thenBothFrontAndBackEnd() {

        List<Developer> developers=new ArrayList<>();
        developers.add(new BackEndDeveloper("Jonas"));
        developers.add(new FrontEndDeveloper("Ruan"));
        Project project=new Project(developers);

        project.implement();

    }

}
