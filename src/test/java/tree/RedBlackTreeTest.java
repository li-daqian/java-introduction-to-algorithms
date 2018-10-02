package tree;

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
public class RedBlackTreeTest {

    private final OutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originStream = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testInsert() {
        RedBlackTree tree = new RedBlackTree();
        StringBuilder out = new StringBuilder();
        for (int i = 10; i < 20; i++) {
            int k = tree.insert(i);
            out.append(i).append("\n");

            Assert.assertEquals(i, k);
        }

        tree.inOrderTreeWalk();
        Assert.assertEquals(out.toString(), outContent.toString());
    }

    @Test
    public void testDeleteNull() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        boolean delete = tree.delete(12);
        Assert.assertFalse(delete);

        tree.inOrderTreeWalk();
        Assert.assertEquals("9\n10\n11\n", outContent.toString());
    }

    @Test
    public void testDelete() {
        RedBlackTree tree = new RedBlackTree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }
        for (int i = 0; i < 10; i++) {
            Assert.assertTrue(tree.delete(i));
        }
    }

    @Test
    public void testDelete1() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        boolean success = tree.delete(9);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("10\n11\n", outContent.toString());
    }

    @Test
    public void testDelete2() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(8);

        boolean success = tree.delete(9);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("8\n10\n11\n", outContent.toString());
    }

    @Test
    public void testDelete3() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(12);

        boolean success = tree.delete(11);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("9\n10\n12\n", outContent.toString());
    }

    @Test
    public void testDelete4() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(13);
        tree.insert(12);
        tree.insert(14);

        boolean success = tree.delete(13);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("9\n10\n12\n14\n", outContent.toString());
    }

    @Test
    public void testDelete5() {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(8);

        tree.insert(13);
        tree.insert(11);
        tree.insert(12);
        tree.insert(14);

        boolean success = tree.delete(10);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("8\n9\n11\n12\n13\n14\n", outContent.toString());
    }

    @After
    public void clean() {
        System.setOut(originStream);
    }
}
