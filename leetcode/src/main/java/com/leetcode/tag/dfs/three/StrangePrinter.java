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

}
