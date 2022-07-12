package effective_java.E_generics_tests.item31;

import effective_java.E_generics.item31.Apple;
import effective_java.E_generics.item31.AsianApple;
import effective_java.E_generics.item31.Fruit;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// PECS. Producer extends Consumer super. Really easy to remember.

public class TestFruitBasket {

    /***
     * Why not add fruits to the basket? The <? extends Fruit> wildcard tells the compiler that we’re dealing
     * with a subtype of the type Fruit, but we CANNOT KNOW WHICH FRUIT as there may be multiple subtypes.
     * In simple words, when you want to ONLY retrieve elements out of a collection, treat it as a producer
     * and use “? extends T>” syntax. “PRODUCER EXTENDS” now should make more sense to you.
     */
    @Test
    public void testExtendFruit()
    {
        //List of apples
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());

        //We can assign a list of apples to a basket of fruits, apple is subtype of fruit
        List<? extends Fruit> basket = apples;

        //Here we know that in basket there is nothing but fruit only
        for (Fruit fruit : basket)
        {
            System.out.println(fruit);
        }

        //basket.add(new Apple()); //Compile time error
        //basket.add(new Fruit()); //Compile time error
    }

    /***
     *  We are not able to add Fruit (super type of apple) to basket. Why?
     * Reason is that basket is a reference to a List of something that is a supertype of Apple.
     * Again, we cannot know which supertype it is, but we know that Apple and any of its subtypes
     * (which are subtype of Fruit) can be added to be without problem (you can always add a subtype
     * in collection of supertype). So, now we can add any type of Apple inside basket.
     *
     * In simple words, when you want to ONLY add elements inside a collection, treat it as a consumer
     * and use “? super T>” syntax. Now, “CONSUMER SUPER” also should make more sense to you.
     */

    @Test
    public void testSuperFruit()  {
        //List of apples
        List<Apple> apples = new ArrayList<Apple>();
        apples.add(new Apple());

        //We can assign a list of apples to a basket of apples, supertype of Apple
        List<? super Apple> basket = apples;

        //Here we know that in basket there is nothing but fruit only
        //for (Fruit fruit : basket)  //Compile time error, we cannot know which supertype it is
        {
        //    System.out.println(fruit);
        }

        basket.add(new Apple());    //Successful
        basket.add(new AsianApple()); //Successful
       // basket.add(new Fruit());    //Compile time error
    }

}
