package select;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author LiDaQian
 */
public class RandomizedSelectTest {

    @Test
    public void testSelect() {
        int[] array = {1, 8, 34, 56, 23, 35, 55};

        int num = RandomizedSelect.select(array, 4);

        Assert.assertEquals(34, num);
    }

    @Test
    public void testErrorSelect() {
        int[] array = {1, 2};
        try {
            RandomizedSelect.select(array, 3);
        } catch (Exception e) {
            Assert.assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
}
