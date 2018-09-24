package queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class PriorityQueueTest {

    @Test
    public void testConstructor() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] maxHeapArray = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};

        PriorityQueue priorityQueue = new PriorityQueue(array);

        Assert.assertArrayEquals(priorityQueue.getArray(), maxHeapArray);
    }

    @Test
    public void testInsert() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        int[] result = {16, 14, 10, 8, 11, 9, 3, 2, 4, 1, 7};

        PriorityQueue priorityQueue = new PriorityQueue(array);
        priorityQueue.insert(11);

        Assert.assertArrayEquals(result, priorityQueue.getArray());
    }

    @Test
    public void testHeapMaximum() {
        int[] array = {16, 33, 33, 14, 7, 11, 22, 2, 8, 1};

        int maximum = new PriorityQueue(array).heapMaximum();

        Assert.assertEquals(33, maximum);
    }

    @Test
    public void testHeapExtractMax() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        PriorityQueue priorityQueue = new PriorityQueue(array);
        int maximum = priorityQueue.heapExtractMax();

        int[] result = {14, 8, 10, 4, 7, 9, 3, 2, 1, 1};

        Assert.assertEquals(16, maximum);
        Assert.assertArrayEquals(result, priorityQueue.getArray());
        Assert.assertEquals(array.length - 1, priorityQueue.getHeapSize());
    }

    @Test
    public void testIncreaseKey() {
        int[] array = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};

        PriorityQueue priorityQueue = new PriorityQueue(array);
        priorityQueue.increaseKey(array.length - 1, 20);

        int[] result = {20, 16, 10, 8, 14, 9, 3, 2, 4, 7};

        Assert.assertArrayEquals(result, array);
    }
}
