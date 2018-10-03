package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class OptimalSubstructureTest {

    @Test
    public void testCutRod() {
        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, OptimalSubstructure.cutRod(prices, 1));
        Assert.assertEquals(5, OptimalSubstructure.cutRod(prices, 2));
        Assert.assertEquals(8, OptimalSubstructure.cutRod(prices, 3));
        Assert.assertEquals(10, OptimalSubstructure.cutRod(prices, 4));
        Assert.assertEquals(13, OptimalSubstructure.cutRod(prices, 5));
        Assert.assertEquals(17, OptimalSubstructure.cutRod(prices, 6));
        Assert.assertEquals(18, OptimalSubstructure.cutRod(prices, 7));
        Assert.assertEquals(22, OptimalSubstructure.cutRod(prices, 8));
        Assert.assertEquals(25, OptimalSubstructure.cutRod(prices, 9));
        Assert.assertEquals(30, OptimalSubstructure.cutRod(prices, 10));
    }
}
