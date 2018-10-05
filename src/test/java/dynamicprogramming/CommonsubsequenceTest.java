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
public class CommonsubsequenceTest {

    private OutputStream content = new ByteArrayOutputStream();
    private PrintStream originStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(content));
    }

    @Test
    public void testLcsLength() {
        String[] x = {"A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"B", "D", "C", "A", "B", "A"};

        int[][] b = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 2, 2, 2, 1, 3, 1},
                {0, 1, 3, 3, 2, 1, 3},
                {0, 2, 2, 1, 3, 2, 2},
                {0, 1, 2, 2, 2, 1, 3},
                {0, 2, 1, 2, 2, 2, 2},
                {0, 2, 2, 2, 1, 2, 1},
                {0, 1, 2, 2, 2, 1, 2}
        };
        int[][] c = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1, 2, 2},
                {0, 1, 1, 2, 2, 2, 2},
                {0, 1, 1, 2, 2, 3, 3},
                {0, 1, 2, 2, 2, 3, 3},
                {0, 1, 2, 2, 3, 3, 4},
                {0, 1, 2, 2, 3, 4, 4}
        };

        Commonsubsequence.Lcs lcs = Commonsubsequence.lcsLength(x, y);

        Assert.assertArrayEquals(b, lcs.b);
        Assert.assertArrayEquals(c, lcs.c);
    }

    @Test
    public void testPrintLcs() {
        String[] x = {"A", "B", "C", "B", "D", "A", "B"};
        String[] y = {"B", "D", "C", "A", "B", "A"};
        String xyLcs = "BCBA";

        Commonsubsequence.Lcs lcs = Commonsubsequence.lcsLength(x, y);
        Commonsubsequence.printLcs(lcs.b, x, x.length, y.length);

        Assert.assertEquals(xyLcs, content.toString());
    }

    @After
    public void clean() {
        System.setOut(originStream);
    }
}
