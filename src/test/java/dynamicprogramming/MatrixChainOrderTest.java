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
public class MatrixChainOrderTest {

    private OutputStream content = new ByteArrayOutputStream();
    private PrintStream originStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(content));
    }

    @Test
    public void testPrintOptimalParens() {
        int[] p = {35, 15, 5, 10, 20, 25};

        MatrixChainOrder.Result result = MatrixChainOrder.order(p);
        MatrixChainOrder.printOptimalParens(result.s, 0, 5);

        Assert.assertEquals("(A1((A2A3)((A4A5)A6)))", content.toString());
    }

    @After
    public void clean() {
        System.setOut(originStream);
    }
}
