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
     * 动态规划
     * <p>
     * 灵活使用 灵活使用 灵活使用
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array/solution/kge-ni-xu-dui-shu-zu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int kInversePairs(int n, int k) {
            //用 f(i, j) 表示数字 [1 .. i] 的排列中恰好包含 j 个逆序对的个数
            int[][] dp = new int[n + 1][k + 1];
            int M = 1000000007;
            for (int i = 1; i <= n; i++) {
                //因为 i 是 [1 .. i] 中的最大值，因此将它放置在 [1 .. i - 1] 的排列中的任意一个位置，它都会与在它之后的那些数形成逆序对
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
