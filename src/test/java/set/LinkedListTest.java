package set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class LinkedListTest {

    @Test
    public void testInsertFirst() {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(1);
        list.insertFirst(2);
        Integer item = list.get(0);

        Assert.assertEquals(2, item.intValue());
    }

    @Test
    public void testInsertLast() {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertFirst(1);
        list.insertLast(2);

        Assert.assertEquals(2, list.get(1).intValue());
    }

    @Test
    public void testGetNull() {
        LinkedList<Integer> list = new LinkedList<>();

        Assert.assertEquals(null, list.get(1));
    }

    @Test
    public void testDeleteNoExist() {
        LinkedList<Integer> list = new LinkedList<>();

        Assert.assertEquals(false, list.delete(1));
    }

    @Test
    public void testDelete() {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            list.insertLast(i);
        }

        Assert.assertEquals(true, list.delete(5));

        for (int i = 0; i < 9; i++) {
            if (i >= 5) {
                Assert.assertEquals(i + 1, list.get(i).intValue());
            } else {
                Assert.assertEquals(i, list.get(i).intValue());
            }
        }
    }
}
