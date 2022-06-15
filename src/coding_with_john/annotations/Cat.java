package coding_with_john.annotations;

@VeryImportant
public class Cat {

    @ImportantField
    String name;

    public Cat() {
        name="Donna";
    }

    public void eat()  {
        System.out.println("eat");
    }

    @RunImmediately
    public void meow()  {
        System.out.println("meow");
    }
}
