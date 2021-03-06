package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 940. 不同的子序列 II
 */
public class DistinctSubseqII {
    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int distinctSubseqII(String S) {
            int MOD = 1_000_000_007;
            int N = S.length();
            int[] dp = new int[N + 1];
            dp[0] = 1;

            int[] last = new int[26];
            // 初始化-1
            Arrays.fill(last, -1);

            for (int i = 0; i < N; ++i) {
                int x = S.charAt(i) - 'a';
                dp[i + 1] = dp[i] * 2 % MOD;
                if (last[x] >= 0) {
                    // 存在
                    dp[i + 1] -= dp[last[x]];
                }
                dp[i + 1] %= MOD;
                // 记录字符出现的下标
                // key----字符 value----下标
                last[x] = i;
            }

            dp[N]--;
            if (dp[N] < 0) {
                dp[N] += MOD;
            }
            return dp[N];
        }
    }

}
