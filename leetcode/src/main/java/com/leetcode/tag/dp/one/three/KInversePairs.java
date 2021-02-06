package com.leetcode.tag.dp.one.three;

/**
 * 629. K个逆序对数组
 * <p>
 * 思路
 * <p>
 * 思路转换
 */
public class KInversePairs {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array/solution/kge-ni-xu-dui-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int kInversePairs(int n, int k) {
            int[][] dp = new int[n + 1][k + 1];
            int M = 1000000007;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k && j <= i * (i - 1) / 2; j++) {
                    if (i == 1 && j == 0) {
                        dp[i][j] = 1;
                        break;
                    } else if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        int val = (dp[i - 1][j] + M - ((j - i) >= 0 ? dp[i - 1][j - i] : 0)) % M;
                        dp[i][j] = (dp[i][j - 1] + val) % M;
                    }
                }
            }
            return dp[n][k];
        }
    }

}
