package com.leetcode.tag.must.seven;

/**
 * 375. 猜数字大小 II
 */
public class GetMoneyAmount {
    public class Solution1 {
        public int calculate(int low, int high) {
            if (low >= high) {
                return 0;
            }
            int minres = Integer.MAX_VALUE;
            for (int i = low; i <= high; i++) {
                // 最坏情况
                int res = i + Math.max(calculate(i + 1, high), calculate(low, i - 1));

                // 最小开销
                minres = Math.min(res, minres);
            }

            return minres;
        }

        public int getMoneyAmount(int n) {
            return calculate(1, n);
        }
    }

    /**
     * 我们需要意识到我们在范围 (1, n) 中猜数字的时候，需要考虑最坏情况下的代价。也就是说要算每次都猜错的情况下的总体最大开销。
     * <p>
     * 在暴力算法中，我们首先在 (1, n) 中任意挑选一个数字，假设它是个错误的猜测（最坏情况），
     * <p>
     * 我们需要用最小代价去猜到需要的数字。那么在一次尝试以后，答案要么在我们猜的数字的左边要么在右边，为了考虑最坏情况，
     * <p>
     * 我们需要考虑两者的较大值。因此，如果我们选择 i 作为第一次尝试，总体最小代价是：
     * <p>
     * cost(1,n)=i+max(cost(1,i−1),cost(i+1,n))
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/solution/cai-shu-zi-da-xiao-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public class Solution {
        public int getMoneyAmount(int n) {
            // dp(i, j) 代表在 (i, j) 中最坏情况下最小开销的代价
            // cost(i,j)=pivot+max(cost(i,pivot−1),cost(pivot+1,n))
            int[][] dp = new int[n + 1][n + 1];
            for (int len = 2; len <= n; len++) {
                for (int start = 1; start <= n - len + 1; start++) {
                    int minres = Integer.MAX_VALUE;
                    for (int piv = start; piv < start + len - 1; piv++) {
                        int res = piv + Math.max(dp[start][piv - 1], dp[piv + 1][start + len - 1]);
                        minres = Math.min(res, minres);
                    }
                    dp[start][start + len - 1] = minres;
                }
            }
            return dp[1][n];
        }
    }
}
