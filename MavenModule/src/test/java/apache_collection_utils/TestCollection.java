package apache_collection_utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.junit.Test;
import org.junit.*;

import java.util.*;

/*

https://www.tutorialspoint.com/commons_collections/commons_collections_inclusion.htm

union() method of CollectionUtils can be used to get the union of two collections.
intersection() method of CollectionUtils can be used to get the common objects between two collections(intersection).
subtract() method of CollectionUtils can be used to get the new collection by subtracting objects of one collection from other

collate() method of CollectionUtils can be used to merge two already sorted lists.
filter() method of CollectionUtils can be used to filter a list to remove objects which do not satisfy condition.
isSubCollection() method of CollectionUtils can be used to check if a collection contains the given collection or not.

 */


public class TestCollection {

    Customer customer1 = new Customer(1, "Daniel", new Address("locality1", "city1"));
    Customer customer2 = new Customer(2, "Fredrik", new Address("locality2", "city2"));
    Customer customer3 = new Customer(3, "Kyle", new Address("locality3", "city3"));
    Customer customer4 = new Customer(4, "Bob", new Address("locality4", "city4"));
    Customer customer5 = new Customer(5, "Cat", new Address("locality5", "city5"));
    Customer customer6 = new Customer(6, "John", new Address("locality6", "city6"));

    List<Customer> list1 = Arrays.asList(customer1, customer2, customer3);
    List<Customer> list2 = Arrays.asList(customer4, customer5, customer6);
    List<Customer> list3 = Arrays.asList(customer1, customer2);

    List<Customer> linkedList1 = new LinkedList<>(list1);



    @Test
    public void givenTwoSortedLists_whenUnion_thenMerged() {
        List<Customer> mergedList = ListUtils.union(list1, list2);
        Assert.assertEquals(6, mergedList.size());
    }


    @Test public void givenTwoList_whenIntersection_commonElementsAreExtracted() {
        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
        List<String> list2 = Arrays.asList("A","A","B","B");
        List<String> listIntersection = (List<String>) CollectionUtils.intersection(list1,list2);

        System.out.println("listIntersection = " + listIntersection);
        Assert.assertTrue(listIntersection.containsAll(Arrays.asList("A","B")));
    }

    @Test public void givenTwoList_whenSubtract_diffElementsAreExtracted() {
        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
        List<String> list2 = Arrays.asList("A","A","B","B");
        List<String> listIntersection = (List<String>) CollectionUtils.subtract(list1,list2);

        System.out.println("listIntersection = " + listIntersection);
        Assert.assertTrue(listIntersection.containsAll(Arrays.asList("A","C")));
    }

    @Test
    public void givenList_whenAddIgnoreNull_thenNoNullAdded() {
        CollectionUtils.addIgnoreNull(list1, null);  //Adding Only Non-Null Elements
        Assert.assertFalse(list1.contains(null));
    }

    @Test
    public void givenTwoSortedLists_whenCollated_thenSorted() {
        List<String> namesA=Arrays.asList("A","B");
        List<String> namesB=Arrays.asList("C","D");
        List<String> mergedList= CollectionUtils.collate(namesA,namesB);

        System.out.println("mergedList = " + mergedList);

        Assert.assertEquals(4, mergedList.size());
    }

    @Test
    public void givenListOfCustomers_whenTransformed_thenListOfAddress() {

        Transformer<Customer, Address> t=(c) -> c.getAddress();
        Collection<Address> addressCol = CollectionUtils.collect(list1,t);

        System.out.println("addressCol = " + addressCol);

        List<Address> addressList = new ArrayList<>(addressCol);
        Assert.assertEquals(3, addressList.size());
        Assert.assertEquals("locality1", addressList.get(0).getLocality());
    }

    @Test
    public void givenListOfStrings_whenTransformed_thenListOfIntegers() {

        List<String> stringList=Arrays.asList("1","2","3");

        Transformer<String, Integer> t=(s) -> Integer.parseInt(s) ;
        Collection<Integer> integerList = CollectionUtils.collect(stringList,t);

        System.out.println("integerList = " + integerList);

        Assert.assertEquals(3, integerList.size());
    }

    @Test
    public void givenNonEmptyList_whenCheckedIsNotEmpty_thenTrue() {
        Assert.assertTrue(CollectionUtils.isNotEmpty(list1));
    }

    @Test
    public void givenEmptyOrNullList_whenCheckedIsEmpty_thenTrue() {
        List<Customer> emptyList = new ArrayList<>();
        List<Customer> nullList = null;

        Assert.assertTrue(CollectionUtils.isEmpty(nullList));
        Assert.assertTrue(CollectionUtils.isEmpty(emptyList));
    }

    @Test
    public void givenCustomerListAndASubcollection_whenChecked_thenTrue() {
        Assert.assertTrue(CollectionUtils.isSubCollection(list3, list1));
    }

    @Test
    public void givenTwoLists_whenUnioned_thenCheckElementPresentInResult() {
        Collection<Customer> union = CollectionUtils.union(list1, list2);

        Assert.assertTrue(union.contains(customer1));
        Assert.assertTrue(union.contains(customer4));
    }


    @Test public void givenIntegerList_whenFilter_onlyEvenRemains() {
        //List<Integer> integerList=Arrays.asList(1,2,3,4,5,6,7,8);

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        Predicate<Integer> p = (n) -> n % 2 == 0;
        CollectionUtils.filter(integerList,p);

        System.out.println("Filtered List (Even numbers): " + integerList);

    }


    @Test public void givenTwoList_whenCheckingInclusion_thenTrue() {
        List<String> list1 = Arrays.asList("A","A","A","C","B","B");
        List<String> list2 = Arrays.asList("A","A","B","B");
        Assert.assertTrue(CollectionUtils.isSubCollection(list2, list1));
    }

}
