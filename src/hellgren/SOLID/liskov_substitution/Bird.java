package hellgren.SOLID.liskov_substitution;

public interface Bird {
    void eat();

    static Bird newOstrich() {
        return new Ostrich();
    }

    static FlyingBird newDuck() {
        return new Duck();
    }

}
