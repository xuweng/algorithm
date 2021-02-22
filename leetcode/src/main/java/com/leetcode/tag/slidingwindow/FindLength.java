package com.leetcode.tag.slidingwindow;

/**
 * 718. 最长重复子数组
 */
public class FindLength {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int findLength(int[] A, int[] B) {
            int n = A.length, m = B.length;
            int[][] dp = new int[n + 1][m + 1];
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    dp[i][j] = A[i] == B[j] ? dp[i + 1][j + 1] + 1 : 0;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

}
