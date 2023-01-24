package hellgren.SOLID.dependency_inversion;

import hellgren.SOLID.dependency_inversion.Developer;

import java.util.List;

public class Project {

    private final List<Developer> developers;

    public Project(List<Developer> developers) {
        this.developers = developers;
    }

    public void implement() {

        developers.forEach(d->d.develop());
    }

}
