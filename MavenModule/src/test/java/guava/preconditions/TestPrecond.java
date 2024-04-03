package guava.preconditions;

import com.google.common.base.Preconditions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;


public class TestPrecond {

    @Test
     void givenErrorMsg_whenCheckArgEvalsFalse_throwsException() {
        int age = -18;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Preconditions.checkArgument(age > 0, "Age not zero or positive"));
    }

    @Test
     void givenArrayAndMsg_whenCheckElementEvalsFalse_throwsException() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->
                Preconditions.checkElementIndex(6, numbers.length - 1, "Please check the bound"));
    }

    @Test
    void whenNullObject_thenCorrect () {
        String string= null;
        Assertions.assertThrows(NullPointerException.class, () ->
                Preconditions.checkNotNull(string, "Please check null"));

    }

    @Test
    void whenInvalidState_thenCorrect () {
        int[] validStates = { -1, 0, 1 };
        int givenState = 10;

        Assertions.assertThrows(IllegalStateException.class, () ->
                Preconditions.checkState(Arrays.binarySearch(validStates, givenState) > 0, "Please check state"));

    }

    @Test
    void whenInvalidStateOrNull_thenCorrect () {
        List<Integer> validStates = List.of(-1, 0, 1);
        Integer givenState = 10;

        Assertions.assertThrows(RuntimeException.class, () ->
        {
            Preconditions.checkState(validStates.contains(givenState), "Please check state");
            Preconditions.checkNotNull(givenState, "Please check null");
        });

    }



}
