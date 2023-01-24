package hellgren.SOLID.interface_segregation.classes;

public class Runner extends AthleteAbstract implements RunnerInterface {
    public Runner(String name) {
        super(name);
    }


    @Override
    public void run() {
        System.out.println("Runner runs");
    }

}
