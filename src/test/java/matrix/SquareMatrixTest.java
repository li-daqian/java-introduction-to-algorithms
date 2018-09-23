package matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class SquareMatrixTest {

    @Test
    public void testMultiply() {
        int[][] a1 = new int[][] {{0, 1}, {0, 0}};
        int[][] b1 = new int[][] {{0, 0}, {1, 0}};
        int[][] c1 = new int[][] {{1, 0}, {0, 0}};

        int[][] a2 = new int[][] {{1, 3}, {7, 5}};
        int[][] b2 = new int[][] {{6, 8}, {4, 2}};
        int[][] c2 = new int[][] {{18, 14}, {62, 66}};

        Assert.assertArrayEquals(c1, SquareMatrix.multiply(a1, b1));
        Assert.assertArrayEquals(c2, SquareMatrix.multiply(a2, b2));
    }

    @Test
    public void testStrassenMultiply() {
        int[][] a1 = new int[][] {{0, 1}, {0, 0}};
        int[][] b1 = new int[][] {{0, 0}, {1, 0}};
        int[][] c1 = new int[][] {{1, 0}, {0, 0}};

        int[][] a2 = new int[][] {{1, 3}, {7, 5}};
        int[][] b2 = new int[][] {{6, 8}, {4, 2}};
        int[][] c2 = new int[][] {{18, 14}, {62, 66}};

        Assert.assertArrayEquals(c1, SquareMatrix.strassenMultiply(a1, b1));
        Assert.assertArrayEquals(c2, SquareMatrix.strassenMultiply(a2, b2));
    }
}
