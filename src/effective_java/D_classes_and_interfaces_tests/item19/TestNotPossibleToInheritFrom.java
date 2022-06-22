package effective_java.D_classes_and_interfaces_tests.item19;

import effective_java.D_classes_and_interfaces.item19.NotPossibleToInheritFrom;
import org.junit.Test;

public class TestNotPossibleToInheritFrom {

    /*  Below gives compile error
    class Dummy extends NotPossibleToInheritFrom {
        public Dummy(int value) {
            super(value);
        }
    }
  */

    @Test
    public void test() {

        NotPossibleToInheritFrom notPossibleToInheritFrom=new NotPossibleToInheritFrom(1);


    }

}
