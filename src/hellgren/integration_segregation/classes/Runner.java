package hellgren.integration_segregation.classes;

public class Runner implements RunnerInterface {
    @Override
    public void compete() {
        System.out.println("Runner competes");
    }

    @Override
    public void run() {
        System.out.println("Runner runs");
    }
}
