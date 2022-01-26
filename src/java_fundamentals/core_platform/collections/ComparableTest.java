package java_fundamentals.core_platform.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class ComparableTest {

    public static class MyClass implements Comparable<MyClass> {
        String label;
        Integer value;

        public MyClass(String label, Integer value) {
            this.label = label;
            this.value = value;
        }

        public String toString() { return label + " | " + value;}
        public boolean equals(Object o) {
            MyClass other = (MyClass) o;
            return value.equals(other.value);
        }
        public int compareTo(MyClass other) {
            return value-other.value;   //neg <=> value<other.value
        }

    }

    public static class MyComparator implements Comparator<MyClass> {
        public int compare(MyClass x, MyClass y) {
            return x.value-y.value;   //neg <=> value<other.value
        }
    }

    public static void main(String[] args) {
        TreeSet<MyClass> tree = new TreeSet<>();
        tree.add(new MyClass("A", 11));
        tree.add(new MyClass("B", 2));
        tree.add(new MyClass("C", 3));
        tree.forEach(m -> System.out.println(m));


        MyComparator mc=new MyComparator();
        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass("A", 11));
        list.add(new MyClass("B", 2));
        list.add(new MyClass("C", 3));
        list.sort(mc);

        System.out.println("list = " + list);


    }



}
