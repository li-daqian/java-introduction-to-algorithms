package greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author LiDaQian
 */
public class GreedyActivityTest {

    @Test
    public void testSelector() {
        int[] s = {1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12};
        int[] f = {4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};

        List<Integer> selector = GreedyActivity.selector(s, f);

        Assert.assertEquals(Arrays.asList(0, 3, 7, 10), selector);
    }
}
