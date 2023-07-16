package ps_new_in_java17_junit5.junit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/***
 * If we have setup or tear-down methods that repeat for some of the tests, but not for all of them,
 * a @Nested test class can be very useful.
 *
 * Furthermore, using nested classes for setting up groups of tests lead to more expressive test scenarios
 * and a clear relationship between our tests.
 */

public class NestedTest {

    @BeforeEach()
    void beforeEach() {
        System.out.println("Always before");
    }

    @Nested
    class ANestedClass {
        @BeforeEach()
        void beforeEach() {
            System.out.println("Before test in A");
        }

        @Test
        void testA1() {
            System.out.println("Test A1");
        }

        @Test
        void testA2() {
            System.out.println("Test A2");
        }
    }

    @Nested
    class BNestedClass {
        @BeforeEach()
        void beforeEach() {
            System.out.println("Before test in B");
        }

        @Test
        void testA1() {
            System.out.println("Test B1");
        }

        @Test
        void testA2() {
            System.out.println("Test B2");
        }
    }

}
