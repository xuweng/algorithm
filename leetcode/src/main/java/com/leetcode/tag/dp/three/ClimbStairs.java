package com.leetcode.tag.dp.three;

/**
 * 70. 爬楼梯
 */
public class ClimbStairs {
    class Solution {
        long[] meno;

        public int climbStairs(int n) {
            meno = new long[n + 1];
            return (int) back(n);
        }

        /**
         * n最大为45.超过会大数溢出.
         *
         * @param n
         * @return
         */
        private long back(int n) {
            if (n < 0) {
                return 0;
            }
            if (n == 1 || n == 0) {
                return 1;
            }
            if (meno[n] != 0) {
                return meno[n];
            }
            // 两个子问题n-1和n-2很接近，肯定会有很多重复子问题
            meno[n] = back(n - 1) + back(n - 2);
            return meno[n];
        }
    }

    /**
     * 递归+备忘录=dp
     */
    class Solution1 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            return dp[n];
        }
    }

    /**
     * 滚动数组
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        /**
         * 随着 n 的不断增大 O(n) 可能已经不能满足我们的需要了，我们可以用「矩阵快速幂」的方法把算法加速到 O(logn)。
         *
         * @param n
         * @return
         */
        public int climbStairs(int n) {
            int p, q = 0, r = 1;
            for (int i = 1; i <= n; ++i) {
                p = q;
                q = r;
                r = p + q;
            }
            return r;
        }
    }

    /**
     * 将一维数组降维成点
     * <p>
     * 如果我们把问题泛化，不再是固定的1，2，而是任意给定台阶数，例如1,2,5呢？
     */
    class Solution3 {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            int[] steps = {1, 2};
            dp[0] = 1;
            for (int i = 1; i <= n; i++) {
                for (int step : steps) {
                    if (i < step) {
                        continue;
                    }
                    dp[i] += dp[i - step];
                }
            }

            return dp[n];
        }
    }

}
