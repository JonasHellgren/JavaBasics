package pluralsight_courses.core_platform.collections;

import java.util.ArrayList;

public class RemoveTest {

    public static class MyClass {
        public String label, value; // getters elided for clarity

        public MyClass(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public boolean equals(Object o) {
            MyClass other = (MyClass) o;
            return label.equalsIgnoreCase(other.label);
        }



    }

    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();
        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "abc");
        MyClass v3 = new MyClass("v3", "abc");
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.remove(v3);   //uses equals method
        for(MyClass m:list)
            System.out.println(m.label);

    }
}
