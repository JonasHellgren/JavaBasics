package mobilapp_java_receipes.algorithms;

import org.junit.Assert;
import org.junit.Test;

public class TestGapSearcher {

    @Test
    public void whenArray_whenCorrectGap() {

        int[] items = { 2, 3, 5, 7, 11, 13, 17 };

        GapSearcher searcher=new GapSearcher(items);

        Assert.assertEquals(-1,searcher.Search(1));
        Assert.assertEquals(3,searcher.Search(7));
        Assert.assertEquals(-1,searcher.Search(19));

    }
}
