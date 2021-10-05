package packt_Java_coding_problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TestCheckNull {

    List<Integer> integersListNull;
    List<Integer> integersListNotNull = new ArrayList<>();

    @Test
    public void isNull() {
        Assert.assertTrue(Objects.isNull(integersListNull));
        Assert.assertFalse(Objects.isNull(integersListNotNull));
    }

    @Test
    public void nonNull() {
        Assert.assertTrue(Objects.nonNull(integersListNotNull));
        Assert.assertFalse(Objects.nonNull(integersListNull));
    }

}