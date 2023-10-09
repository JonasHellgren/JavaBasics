package mobilapp_java_receipes.classes;

import org.junit.Test;

public class TestNested {

    static class SomeClass {

        NestedClass create() {
            return new NestedClass();
        }

        static class NestedClass {}

        static class NestedStaticClass {}
    }

    @Test
    public void test() {
        var someClass = new SomeClass();
        SomeClass.NestedClass nested1 = someClass.create();
        SomeClass.NestedClass nested2 = new SomeClass.NestedClass();
        SomeClass.NestedStaticClass nestedStatic = new SomeClass.NestedStaticClass();

        System.out.println(nested1);
        System.out.println(nested2);
        System.out.println(nestedStatic);

    }

}
