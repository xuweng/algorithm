package com.leetcode.tag.daily.six;

/**
 * 376. 摆动序列
 */
public class WiggleMaxLength {
    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/wiggle-subsequence/solution/bai-dong-xu-lie-by-leetcode-solution-yh2m/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            int n = nums.length;
            if (n < 2) {
                return n;
            }
            int[] up = new int[n];
            int[] down = new int[n];
            up[0] = down[0] = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i] > nums[i - 1]) {
                    up[i] = Math.max(up[i - 1], down[i - 1] + 1);
                    down[i] = down[i - 1];
                } else if (nums[i] < nums[i - 1]) {
                    up[i] = up[i - 1];
                    down[i] = Math.max(up[i - 1] + 1, down[i - 1]);
                } else {
                    up[i] = up[i - 1];
                    down[i] = down[i - 1];
                }
            }
            return Math.max(up[n - 1], down[n - 1]);
        }
    }

}
