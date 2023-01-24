package hellgren.SOLID.test;

import hellgren.SOLID.liskov_substitution.Bird;
import hellgren.SOLID.liskov_substitution.Duck;
import hellgren.SOLID.liskov_substitution.FlyingBird;
import hellgren.SOLID.liskov_substitution.Ostrich;
import org.junit.Test;

/***
 * Ostrich is a bird that cannot fly, hence we shall not declare it a FlyingBird and let fly method be empty
 */

public class TestLiskov {

    @Test
    public void whenOstrich_thenCanEat() {
        Bird ostrich=new Ostrich();
        ostrich.eat();
        //ostrich.fly();  //does not compile
    }


    @Test
    public void whenFlyingBird_thenCanEatAndFly() {
        FlyingBird duck=new Duck();
        duck.eat();
        duck.fly();  //does not compile
    }

    @Test
    public void whenDuck_thenCanEatAndFly() {
        Duck duck=new Duck();
        duck.eat();
        duck.fly();  //does not compile
    }

}
