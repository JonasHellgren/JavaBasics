package effective_java.E_generics_tests.item28;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestArraysVsLists {

    @Test(expected = ArrayStoreException.class)
    public void testArray() {
        Object[] arr=new Long[1];
        arr[0]="I don't fit";  //fails at run time
    }

    public void testList() {
        List<Long> list=new ArrayList<>();
        //list.add("I don't fit");  //fails fast at compile time
    }

}
