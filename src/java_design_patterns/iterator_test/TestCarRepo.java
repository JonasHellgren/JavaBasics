package java_design_patterns.iterator_test;

import java_design_patterns.iterator.CarRepo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestCarRepo {

    CarRepo repo;

    @Before
    public void init() {
        repo=new CarRepo();
    }

    @Test
    public void whenEmptyRepo_thenHasNextIsFalse() {
        Assert.assertFalse(repo.iterator().hasNext());

    }

    @Test
    public void whenNonEmptyRepo_thenHasNextIsNotFalse() {
        repo.add("VW");
        Assert.assertTrue(repo.iterator().hasNext());
    }


    @Test
    public void whenNonEmptyRepoAndListWithOwner_thenCanCombined() {
        List<String> owners=List.of("Jonas","Rune");
        repo.add("VW");
        repo.add("Renault");
        List<String> carsAndOwners=new ArrayList<>();
        Iterator<String> ownersIterator= owners.iterator();

        for (String car:repo) {
            carsAndOwners.add(car+" is owned by "+ownersIterator.next());
        }

        System.out.println("carsAndOwners = " + carsAndOwners);


    }

}
