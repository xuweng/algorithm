package com.leetcode.tag.daily.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 四数相加 II
 * <p>
 * 学算法。学算法。学算法。
 */
public class FourSumCount {
    /**
     * 方法一：分组 + 哈希表
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/4sum-ii/solution/si-shu-xiang-jia-ii-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * 可以将四个数组分成两部分，A 和 B 为一组，C 和 D 为另外一组。
         *
         * @param A
         * @param B
         * @param C
         * @param D
         * @return
         */
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> countAB = new HashMap<>();
            for (int u : A) {
                for (int v : B) {
                    countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
                }
            }
            int ans = 0;
            for (int u : C) {
                for (int v : D) {
                    if (countAB.containsKey(-u - v)) {
                        ans += countAB.get(-u - v);
                    }
                }
            }
            return ans;
        }
    }

}
