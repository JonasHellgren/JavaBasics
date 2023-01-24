package hellgren.SOLID.liskov_substitution;

public class Ostrich implements Bird {
    @Override
    public void eat() {
        System.out.println("Bird eating");
    }
}
