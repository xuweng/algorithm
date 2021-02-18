package com.leetcode.tag.daily.eight;

import java.util.HashMap;
import java.util.Map;

/**
 * 765. 情侣牵手
 * <p>
 * 本质 本质 本质
 * <p>
 * 滑动窗口 哈希表
 */
public class MinSwapsCouples {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/couples-holding-hands/solution/qing-lu-qian-shou-by-leetcode-solution-bvzr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int tot = n / 2;
            int[] f = new int[tot];
            for (int i = 0; i < tot; i++) {
                f[i] = i;
            }

            for (int i = 0; i < n; i += 2) {
                int l = row[i] / 2;
                int r = row[i + 1] / 2;
                add(f, l, r);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tot; i++) {
                int fx = getf(f, i);
                map.put(fx, map.getOrDefault(fx, 0) + 1);
            }

            int ret = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ret += entry.getValue() - 1;
            }
            return ret;
        }

        public int getf(int[] f, int x) {
            if (f[x] == x) {
                return x;
            }
            int newf = getf(f, f[x]);
            f[x] = newf;
            return newf;
        }

        public void add(int[] f, int x, int y) {
            int fx = getf(f, x);
            int fy = getf(f, y);
            f[fx] = fy;
        }
    }

}
