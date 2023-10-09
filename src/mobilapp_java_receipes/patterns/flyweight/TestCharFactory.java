package mobilapp_java_receipes.patterns.flyweight;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCharFactory {

    //ConcreteFlyweight
    class Char {
        protected char c;
        public Char(char c) {
            this.c = c;
        }
    }

    //FlyweightFactory
    class CharFactory {
        Map<Character, Char> chars = new HashMap<>();

        //GetFlyweight(key)
        public Char getChar(char c) {
            var character = chars.get(c);
            if (character == null) {
                character = new Char(c);
                chars.put(c, character);
            }
            return character;
        }
    }

    @Test
    public void givenFactory() {
        var factory = new CharFactory();
        var charA = factory.getChar('A');
        var charB = factory.getChar('B');
        var charA1 = factory.getChar('A');

        Assert.assertEquals(charA,charA1);  //same object used again
        Assert.assertNotEquals(charA,charB);  //different objects created in factory

    }


}
