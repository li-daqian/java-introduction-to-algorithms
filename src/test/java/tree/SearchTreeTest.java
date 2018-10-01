package tree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * @author LiDaQian
 */
public class SearchTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void testPreOrderTreeWalk() {
        SearchTree tree = new SearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(8);

        tree.preOrderTreeWalk();

        Assert.assertEquals("10\n9\n8\n11\n", outContent.toString());
    }

    @Test
    public void testInOrderTreeWalk() {
        SearchTree tree = new SearchTree();
        tree.insert(3);
        tree.insert(2);
        tree.insert(5);
        tree.insert(4);
        tree.insert(6);

        tree.inOrderTreeWalk();

        Assert.assertEquals("2\n3\n4\n5\n6\n", outContent.toString());
    }

    @Test
    public void testPostOrderTreeWalk() {
        SearchTree tree = new SearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);
        tree.insert(8);

        tree.postOrderTreeWalk();

        Assert.assertEquals("8\n9\n11\n10\n", outContent.toString());
    }

    @Test
    public void testSearch() {
        SearchTree tree = new SearchTree();
        for (int i = 0; i < 3; i++) {
            tree.insert(i);
        }

        Assert.assertEquals(true, tree.search(0));
        Assert.assertEquals(true, tree.search(1));
        Assert.assertEquals(true, tree.search(2));
        Assert.assertEquals(false, tree.search(3));
    }

    @Test
    public void testIterativeSearch() {
        SearchTree tree = new SearchTree();
        for (int i = 3; i < 6; i++) {
            tree.insert(i);
        }

        Assert.assertEquals(true, tree.iterativeSearch(3));
        Assert.assertEquals(true, tree.iterativeSearch(4));
        Assert.assertEquals(true, tree.iterativeSearch(5));
        Assert.assertEquals(false, tree.iterativeSearch(6));
    }

    @Test
    public void testNullMinimum() {
        SearchTree tree = new SearchTree();

        Assert.assertEquals(null, tree.minimum());
    }

    @Test
    public void testMinimum() {
        SearchTree tree = new SearchTree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }
        tree.insert(-10);

        Assert.assertEquals(-10, tree.minimum().intValue());
    }

    @Test
    public void testNullMaximum() {
        SearchTree tree = new SearchTree();

        Assert.assertEquals(null, tree.maximum());
    }

    @Test
    public void testMaximum() {
        SearchTree tree = new SearchTree();
        for (int i = 0; i < 10; i++) {
            tree.insert(i);
        }

        Assert.assertEquals(9, tree.maximum().intValue());
    }

    @Test
    public void testInsert() {
        SearchTree tree = new SearchTree();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int k = tree.insert(i);
            out.append(i).append("\n");

            Assert.assertEquals(i, k);
        }

        tree.inOrderTreeWalk();
        Assert.assertEquals(out.toString(), outContent.toString());
    }

    @Test
    public void testDeleteNull() {
        SearchTree tree = new SearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        boolean delete = tree.delete(12);
        Assert.assertFalse(delete);

        tree.inOrderTreeWalk();
        Assert.assertEquals("9\n10\n11\n", outContent.toString());
    }

    @Test
    public void testDeleteLeaf() {
        SearchTree tree = new SearchTree();
        tree.insert(10);
        tree.insert(9);
        tree.insert(11);

        boolean success = tree.delete(9);
        Assert.assertTrue(success);

        tree.inOrderTreeWalk();
        Assert.assertEquals("10\n11\n", outContent.toString());
    }

    @Test
    public void testDeleteWithOneLeft() {
        SearchTree tree = new SearchTree();
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
    public void testDeleteWithOneRight() {
        SearchTree tree = new SearchTree();
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
    public void testDeleteWithTwoSampleChild() {
        SearchTree tree = new SearchTree();
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
    public void testDeleteWithComplexChild() {
        SearchTree tree = new SearchTree();
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
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
}
