package com.leetcode.tag.daily.nine;

/**
 * 44. 通配符匹配
 */
public class IsMatch1 {
    /**
     * 方法一：动态规划
     * <p>
     * 模式 p  中的任意一个字符都是独立的，即不会和前后的字符互相关联，形成一个新的匹配模式
     * <p>
     * 在给定的模式  p 中，只会有三种类型的字符出现：
     * <p>
     * 小写字母 a-z ，可以匹配对应的一个小写字母；
     * <p>
     * 问号 ? ，可以匹配任意一个小写字母；
     * <p>
     * 星号 * ，可以匹配任意字符串，可以为空，也就是匹配零或任意多个小写字母。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/wildcard-matching/solution/tong-pei-fu-pi-pei-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 1; i <= n; ++i) {
                if (p.charAt(i - 1) == '*') {
                    dp[0][i] = true;
                } else {
                    break;
                }
            }
            for (int i = 1; i <= m; ++i) {
                for (int j = 1; j <= n; ++j) {
                    if (p.charAt(j - 1) == '*') {
                        // 号可以匹配零或任意多个小写字母，因此状态转移方程分为两种情况，即使用或不使用这个星号
                        // 如果我们不使用这个星号，那么就会从 dp[i][j−1] 转移而来；
                        // 如果我们使用这个星号，那么就会从 dp[i−1][j] 转移而来
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                    } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
            return dp[m][n];
        }
    }

}
