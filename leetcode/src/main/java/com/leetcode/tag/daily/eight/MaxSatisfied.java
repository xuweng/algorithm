package com.leetcode.tag.daily.eight;

/**
 * 1052. 爱生气的书店老板
 */
public class MaxSatisfied {
    /**
     * 方法一：滑动窗口
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/grumpy-bookstore-owner/solution/ai-sheng-qi-de-shu-dian-lao-ban-by-leetc-dloq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {
            int total = 0;
            int n = customers.length;
            for (int i = 0; i < n; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                }
            }
            int increase = 0;
            for (int i = 0; i < X; i++) {
                increase += customers[i] * grumpy[i];
            }
            int maxIncrease = increase;
            for (int i = X; i < n; i++) {
                increase = increase - customers[i - X] * grumpy[i - X] + customers[i] * grumpy[i];
                maxIncrease = Math.max(maxIncrease, increase);
            }
            return total + maxIncrease;
        }
    }

}
