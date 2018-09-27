package set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class QueueTest {

    @Test
    public void testEnQueue() {
        Queue<Integer> queue = new Queue<>(10);

        queue.enQueue(10);
        queue.enQueue(20);

        Integer item = queue.deQueue();
        Assert.assertEquals(10, item.intValue());
    }

    @Test
    public void testMultiEnQueue() {
        Queue<Integer> queue = new Queue<>(10);

        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        for (int i = 0; i < 5; i++) {
            Integer item = queue.deQueue();
            Assert.assertEquals(i, item.intValue());
        }

        for (int i = 10; i < 15; i++) {
            queue.enQueue(i);
        }

        for (int i = 5; i < 15; i++) {
            Integer item = queue.deQueue();
            Assert.assertEquals(i, item.intValue());
        }
    }

    @Test
    public void testEmptyQueue() {
        Queue<Integer> queue = new Queue<>(10);

        try {
            queue.deQueue();
        } catch (Exception e) {
            Assert.assertEquals(IllegalStateException.class, e.getClass());
        }
    }

    @Test
    public void testFullQueue() {
        Queue<Integer> queue = new Queue<>(10);

        for (int i = 0; i < 10; i++) {
            queue.enQueue(i);
        }

        try {
            queue.enQueue(0);
        } catch (Exception e) {
            Assert.assertEquals(IllegalStateException.class, e.getClass());
        }
    }
}
