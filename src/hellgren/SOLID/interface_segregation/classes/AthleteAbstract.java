package hellgren.interface_segregation.classes;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AthleteAbstract implements AthleteInterface {
    String name;

    @Override
    public void compete() {
        System.out.println(name+" competes");
    }
}
