package com.leetcode.tag.dfs.three;

/**
 * 664. 奇怪的打印机
 * <p>
 * dfs.dfs.dfs.
 * <p>
 * 十分钟.十分钟.十分钟.
 * <p>
 * 经典题目.经典题目.经典题目.
 */
public class StrangePrinter {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/qi-guai-de-da-yin-ji-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        // 缓存
        int[][] memo;

        public int strangePrinter(String s) {
            int n = s.length();
            memo = new int[n][n];
            return dp(s, 0, n - 1);
        }

        /**
         * dp(i, j) 指的是打印 S[i], S[i+1], ..., S[j] 所需的次数
         *
         * @param s
         * @param i
         * @param j
         * @return
         */
        public int dp(String s, int i, int j) {
            if (i > j) {
                return 0;
            }
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            int ans = dp(s, i + 1, j) + 1;
            for (int k = i + 1; k <= j; ++k) {
                if (s.charAt(k) == s.charAt(i)) {
                    ans = Math.min(ans, dp(s, i, k - 1) + dp(s, k + 1, j));
                }
            }
            memo[i][j] = ans;
            return memo[i][j];
        }
    }

    /**
     * 区间DP
     * <p>
     * 作者：GitKid
     * 链接：https://leetcode-cn.com/problems/strange-printer/solution/java-yan-shi-dpfen-xi-fa-qu-jian-dp-qing-xi-yi-don/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int strangePrinter(String s) {
            int n = s.length();
            if (n == 0) {
                return 0;
            }
            int[][] dp = new int[n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                dp[i][i] = 1;
            }
            for (int len = 2; len <= n; len++) {
                // 枚举i
                for (int i = 0; i + len - 1 < n; i++) {
                    int j = i + len - 1;
                    dp[i][j] = dp[i + 1][j] + 1;
                    // i,k,j
                    // 枚举k
                    for (int k = i + 1; k <= j; k++) {
                        if (s.charAt(i) == s.charAt(k)) {
                            dp[i][j] = Math.min(dp[i][j], dp[i][k - 1] + dp[k + 1][j]);
                        }
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

}
