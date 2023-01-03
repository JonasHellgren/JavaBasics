package hellgren.integration_segregation.classes;

public class Swimmer implements SwimmerInterface {
    @Override
    public void compete() {
        System.out.println("Swimmer competes");
    }

    @Override
    public void swim() {
        System.out.println("Swimmer swims");

    }
}
