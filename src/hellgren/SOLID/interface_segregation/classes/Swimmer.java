package hellgren.interface_segregation.classes;

public class Swimmer extends AthleteAbstract implements SwimmerInterface {
    public Swimmer(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println("Swimmer swims, name = "+this.name);
    }
}
