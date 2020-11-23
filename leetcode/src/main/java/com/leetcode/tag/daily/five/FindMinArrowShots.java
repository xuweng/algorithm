package com.leetcode.tag.daily.five;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 */
public class FindMinArrowShots {
    /**
     * 方法一：排序 + 贪心算法
     * <p>
     * 重叠区间
     * <p>
     * 为了方便在一次遍历中识别重合，先排序。是按区间左端还是右端排升序呢？
     * <p>
     * 按右端升序。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/yong-zui-shao-shu-liang-de-jian-yin-bao-qi-qiu-1-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(point -> point[1]));
            int pos = points[0][1];
            int ans = 1;
            for (int[] balloon : points) {
                if (balloon[0] > pos) {
                    pos = balloon[1];
                    ++ans;
                }
            }
            return ans;
        }
    }

}
