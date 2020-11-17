package com.leetcode.tag.daily.five;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 1030. 距离顺序排列矩阵单元格
 */
public class AllCellsDistOrder {
    /**
     * 方法一：直接排序
     * <p>
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

    /**
     * 方法二：桶排序
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/matrix-cells-in-distance-order/solution/ju-chi-shun-xu-pai-lie-ju-zhen-dan-yuan-ge-by-leet/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int maxDist = Math.max(r0, R - 1 - r0) + Math.max(c0, C - 1 - c0);
            List<List<int[]>> bucket = IntStream.rangeClosed(0, maxDist).<List<int[]>>mapToObj(i -> new ArrayList<>()).collect(Collectors.toList());

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int d = dist(i, j, r0, c0);
                    // 放入对应的桶
                    bucket.get(d).add(new int[]{i, j});
                }
            }
            int[][] ret = new int[R * C][];
            int index = 0;
            for (int i = 0; i <= maxDist; i++) {
                for (int[] it : bucket.get(i)) {
                    ret[index++] = it;
                }
            }
            return ret;
        }

        public int dist(int r1, int c1, int r2, int c2) {
            return Math.abs(r1 - r2) + Math.abs(c1 - c2);
        }
    }

}
