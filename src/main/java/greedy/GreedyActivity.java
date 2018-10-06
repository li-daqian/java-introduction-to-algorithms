package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiDaQian
 */
public class GreedyActivity {

    /**
     * <p>迭代贪心算法
     *
     * <p>计算最大的互相兼容的活动集合
     * @param s 开始时间数组并已排序
     * @param f 结束时间数组并已排序
     * @return 最大的互相兼容的活动集合
     */
    public static List<Integer> selector(int[] s, int[] f) {
        List<Integer> result = new ArrayList<>();
        result.add(0);

        int n = s.length;
        int k = 0;
        for (int m = 1; m < n; m++) {
            if (s[m] >= f[k]) {
                result.add(m);
                k = m;
            }
        }

        return result;
    }
}
