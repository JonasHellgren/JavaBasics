package java_design_patterns.G_mediator_test;

import hellgren.performance_test.ListUtils;
import java_design_patterns.G_mediator.random_walk.walker.RandomWalker;
import org.apache.commons.math3.util.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.IntStream;

public class TestRandomWalker {

    public static final int MIN = 0;
    public static final int MAX = 10;
    public static final int START = 5;
    RandomWalker walker;

    @Before
    public void init() {
        walker=new RandomWalker(START, Pair.create(MIN, MAX));
    }

    @Test
    public void whenInit_thenHistoryIs5() {
        Assert.assertEquals(walker.getHistory(), List.of(START));
    }

    @Test
    public void whenManySteps_thenHistoryIsCorrect() {
        int nofSteps = 1000;
        IntStream.range(0, nofSteps).forEach(i -> walker.step());
        List<Integer> list = ListUtils.generateIntegersLinSpace(MIN, MAX, 1);

        Assert.assertEquals((long) nofSteps+1,walker.getHistory().size());
        Assert.assertTrue(walker.getHistory().containsAll(list)); //small nofSteps => high fail risk
    }


}
