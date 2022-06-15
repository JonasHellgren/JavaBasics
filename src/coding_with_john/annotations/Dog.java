package coding_with_john.annotations;

public class Dog {

    public void eat()  {
        System.out.println("eat");
    }

    @RunImmediately(times=3)
    public void bark()  {
        System.out.println("bark");
    }
}
