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
            int n = A.length;
            int m = B.length;
            int[][] dp = new int[n + 1][m + 1]; // dp[i][j]表示A的前i项与B的前j项的最长重复子数组长度
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
            return ans;
        }
    }

    /**
     * 滚动数组
     */
    class Solution1 {
        /**
         * 子数组 不是子序列
         *
         * @param A
         * @param B
         * @return
         */
        public int findLength(int[] A, int[] B) {
            int n = A.length;
            int m = B.length;
            int[] dp = new int[m + 1];
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                // 倒序遍历
                for (int j = m; j >= 1; j--) {
                    if (A[i - 1] == B[j - 1]) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        // 必须置0
                        dp[j] = 0;
                    }
                    ans = Math.max(ans, dp[j]);
                }
            }
            return ans;
        }
    }

}
