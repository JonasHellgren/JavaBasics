package java_design_patterns.decorator_test;

import java_design_patterns.decorator.Chicken;
import java_design_patterns.decorator.Lettuce;
import java_design_patterns.decorator.Sandwich;
import java_design_patterns.decorator.WholeWheat;
import org.junit.Assert;
import org.junit.Test;

/**
 * ToppingDecorator takes a sandwich object and modififies its methods
 * Original methods are still used, but deccorated with on top functionality
 */


public class TestSandwich {

    @Test
    public void whenSandwich_theCorrectCost() {
        Sandwich sandwich=new WholeWheat();
        Assert.assertEquals(1.5d,sandwich.cost(),0.1);

        System.out.println("sandwich = " + sandwich.getDescription());
    }


    @Test
    public void whenCombinedSandwich_theCorrectCost() {
        Sandwich sandwich=new WholeWheat();

        Sandwich chickenSandwich=new Chicken(sandwich);
        Sandwich  combinedSandwich=new Lettuce(chickenSandwich);

        Assert.assertEquals(1.5d,sandwich.cost(),0.1);
        Assert.assertTrue(combinedSandwich.cost() > sandwich.cost());

        System.out.println("combinedSandwich = " + combinedSandwich.getDescription());
    }



}
