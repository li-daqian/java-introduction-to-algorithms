package set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class StackTest {

    @Test
    public void testPush() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        Integer item = stack.pop();

        Assert.assertEquals(10, item.intValue());
    }

    @Test
    public void testEmpty() {
        Stack<Integer> stack = new Stack<>();
        Assert.assertEquals(true, stack.empty());

        stack.push(1);
        Assert.assertEquals(false, stack.empty());

        stack.pop();
        Assert.assertEquals(true, stack.empty());
    }

    @Test
    public void testMultiPush() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 100; i++) {
            stack.push(i);
        }

        for (int i = 99; i >= 0; i--) {
            Integer item = stack.pop();
            Assert.assertEquals(i, item.intValue());
        }

        Assert.assertEquals(true, stack.empty());
    }
}
