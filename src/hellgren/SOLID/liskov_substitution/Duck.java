package hellgren.SOLID.liskov_substitution;

public class Duck implements FlyingBird {
    @Override
    public void eat() {
        System.out.println("Eating duck");
    }

    @Override
    public void fly() {
        System.out.println("Flying bird");
    }
}
