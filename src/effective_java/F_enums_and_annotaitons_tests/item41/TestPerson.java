package effective_java.F_enums_and_annotaitons_tests.item41;

import effective_java.F_enums_and_annotaitons.item41.PersonDefaultCase;
import effective_java.F_enums_and_annotaitons.item41.PersonUpperCase;
import org.junit.Assert;
import org.junit.Test;

public class TestPerson {

    @Test
    public void testUpperCase() {
        PersonUpperCase person=new PersonUpperCase("Jonas");
        System.out.println("person = " + person);
        Assert.assertTrue(isStringUpperCase(person.toString()));
    }

    @Test
    public void testDefault() {
        PersonDefaultCase person=new PersonDefaultCase("Jonas");
        System.out.println("person = " + person);
        Assert.assertFalse(isStringUpperCase(person.toString()));
    }


    private static boolean isStringUpperCase(String str){

        //convert String to char array
        char[] charArray = str.toCharArray();

        for(int i=0; i < charArray.length; i++){

            //if any character is in lower case, return false
            if( Character.isLowerCase( charArray[i] ))
                return false;
        }

        return true;
    }

}
