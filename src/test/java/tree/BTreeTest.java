package tree;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class BTreeTest {

    @Test
    public void testInsert() {
        BTree<String> tree = new BTree<>(3);
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.insert("H");
        tree.insert("M");
        tree.insert("L");
        tree.insert("J");
        tree.insert("K");
        tree.insert("N");
        tree.insert("O");
        tree.insert("R");
        tree.insert("S");
        tree.insert("T");
        tree.insert("U");
        tree.insert("V");
        tree.insert("Y");
        tree.insert("Z");

        Assert.assertEquals(null, tree.search("AA"));

        BTree<String>.Result result1 = tree.search("A");
        BTree<String>.Result result2 = tree.search("B");
        BTree<String>.Result result3 = tree.search("C");
        BTree<String>.Result result4 = tree.search("D");
        BTree<String>.Result result5 = tree.search("E");
        BTree<String>.Result result6 = tree.search("F");
        BTree<String>.Result result7 = tree.search("G");
        BTree<String>.Result result8 = tree.search("H");
        BTree<String>.Result result9 = tree.search("M");
        BTree<String>.Result result10 = tree.search("L");
        BTree<String>.Result result11 = tree.search("J");
        BTree<String>.Result result12 = tree.search("K");
        BTree<String>.Result result13 = tree.search("N");
        BTree<String>.Result result14 = tree.search("O");
        BTree<String>.Result result15 = tree.search("R");
        BTree<String>.Result result16 = tree.search("S");
        BTree<String>.Result result17 = tree.search("T");
        BTree<String>.Result result18 = tree.search("U");
        BTree<String>.Result result19 = tree.search("V");
        BTree<String>.Result result20 = tree.search("Y");
        BTree<String>.Result result21 = tree.search("Z");

        Assert.assertEquals("A", result1.node.key.get(result1.index));
        Assert.assertEquals("B", result2.node.key.get(result2.index));
        Assert.assertEquals("C", result3.node.key.get(result3.index));
        Assert.assertEquals("D", result4.node.key.get(result4.index));
        Assert.assertEquals("E", result5.node.key.get(result5.index));
        Assert.assertEquals("F", result6.node.key.get(result6.index));
        Assert.assertEquals("G", result7.node.key.get(result7.index));
        Assert.assertEquals("H", result8.node.key.get(result8.index));
        Assert.assertEquals("M", result9.node.key.get(result9.index));
        Assert.assertEquals("L", result10.node.key.get(result10.index));
        Assert.assertEquals("J", result11.node.key.get(result11.index));
        Assert.assertEquals("K", result12.node.key.get(result12.index));
        Assert.assertEquals("N", result13.node.key.get(result13.index));
        Assert.assertEquals("O", result14.node.key.get(result14.index));
        Assert.assertEquals("R", result15.node.key.get(result15.index));
        Assert.assertEquals("S", result16.node.key.get(result16.index));
        Assert.assertEquals("T", result17.node.key.get(result17.index));
        Assert.assertEquals("U", result18.node.key.get(result18.index));
        Assert.assertEquals("V", result19.node.key.get(result19.index));
        Assert.assertEquals("Y", result20.node.key.get(result20.index));
        Assert.assertEquals("Z", result21.node.key.get(result21.index));

    }
}
