package com.leetcode.tag.daily.five;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 1030. 距离顺序排列矩阵单元格
 */
public class AllCellsDistOrder {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order/solution/ju-chi-shun-xu-pai-lie-ju-zhen-dan-yuan-ge-by-leet/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] ret = new int[R * C][];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    ret[i * C + j] = new int[]{i, j};
                }
            }
            Arrays.sort(ret, Comparator.comparingInt(a -> (Math.abs(a[0] - r0) + Math.abs(a[1] - c0))));
            return ret;
        }
    }

}
