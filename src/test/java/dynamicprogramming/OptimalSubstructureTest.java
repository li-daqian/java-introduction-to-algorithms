package dynamicprogramming;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author LiDaQian
 */
public class OptimalSubstructureTest {

    private OutputStream outContent = new ByteArrayOutputStream();
    private PrintStream originStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

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

    @Test
    public void testMemoizedCutRod() {
        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, OptimalSubstructure.memoizedCutRod(prices, 1));
        Assert.assertEquals(5, OptimalSubstructure.memoizedCutRod(prices, 2));
        Assert.assertEquals(8, OptimalSubstructure.memoizedCutRod(prices, 3));
        Assert.assertEquals(10, OptimalSubstructure.memoizedCutRod(prices, 4));
        Assert.assertEquals(13, OptimalSubstructure.memoizedCutRod(prices, 5));
        Assert.assertEquals(17, OptimalSubstructure.memoizedCutRod(prices, 6));
        Assert.assertEquals(18, OptimalSubstructure.memoizedCutRod(prices, 7));
        Assert.assertEquals(22, OptimalSubstructure.memoizedCutRod(prices, 8));
        Assert.assertEquals(25, OptimalSubstructure.memoizedCutRod(prices, 9));
        Assert.assertEquals(30, OptimalSubstructure.memoizedCutRod(prices, 10));
    }

    @Test
    public void testBottomUpCutRod() {
        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        Assert.assertEquals(1, OptimalSubstructure.bottomUpCutRod(prices, 1));
        Assert.assertEquals(5, OptimalSubstructure.bottomUpCutRod(prices, 2));
        Assert.assertEquals(8, OptimalSubstructure.bottomUpCutRod(prices, 3));
        Assert.assertEquals(10, OptimalSubstructure.bottomUpCutRod(prices, 4));
        Assert.assertEquals(13, OptimalSubstructure.bottomUpCutRod(prices, 5));
        Assert.assertEquals(17, OptimalSubstructure.bottomUpCutRod(prices, 6));
        Assert.assertEquals(18, OptimalSubstructure.bottomUpCutRod(prices, 7));
        Assert.assertEquals(22, OptimalSubstructure.bottomUpCutRod(prices, 8));
        Assert.assertEquals(25, OptimalSubstructure.bottomUpCutRod(prices, 9));
        Assert.assertEquals(30, OptimalSubstructure.bottomUpCutRod(prices, 10));
    }

    @Test
    public void testPrintCutRodSolution() {
        int[] prices = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        OptimalSubstructure.printCutRodSolution(prices, 7);

        Assert.assertEquals("1\n6\n", outContent.toString());
    }

    @After
    public void clean() {
        System.setOut(originStream);
    }
}
