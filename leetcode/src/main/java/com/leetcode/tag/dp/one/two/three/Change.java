package com.leetcode.tag.dp.one.two.three;

import java.util.Arrays;

/**
 * 518. 零钱兑换 II
 */
public class Change {
    static class Solution {
        int[] meno;

        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
            if (coins.length == 0 && amount == 0) {
                return 1;
            }
            Arrays.sort(coins);

            meno = new int[amount + 1];

            int back = back(amount, coins, 0);

            return back;
        }

        /**
         * 一定要start,只需要从start开始递归
         * <p>
         * 缓存错误
         *
         * @param amount
         * @param coins
         * @param start
         * @return
         */
        private int back(int amount, int[] coins, int start) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0) {
                return 0;
            }
            if (meno[amount] != 0) {
                return meno[amount];
            }
            int result = 0;
            for (int i = start; i < coins.length; i++) {
                if (coins[i] > amount) {
                    // 注意不是return
                    break;
                }
                // 注意递归的start是i
                result += back(amount - coins[i], coins, i);
            }
            meno[amount] = result;
            return meno[amount];
        }
    }

    /**
     * 缓存错误答案
     * <p>
     * 继续递归计算
     */
    class Solution1 {
        public int change(int amount, int[] coins) {
            if (coins == null) {
                return 0;
            }
            if (coins.length == 0 && amount == 0) {
                return 1;
            }
            Arrays.sort(coins);

            int back = back(amount, coins, 0);

            return back;
        }

        /**
         * 一定要start,只需要从start开始递归
         * <p>
         * 500
         * [3,5,7,8,9,10,11]
         * <p>
         * amount越大，递归树越高
         * <p>
         * 缓存错误
         *
         * @param amount
         * @param coins
         * @param start  从start开始选择
         * @return
         */
        private int back(int amount, int[] coins, int start) {
            if (amount == 0) {
                return 1;
            }
            if (amount < 0) {
                return 0;
            }
            int result = 0;
            for (int i = start; i < coins.length; i++) {
                if (coins[i] > amount) {
                    // 注意不是return
                    break;
                }
                // 注意递归的start是i
                result += back(amount - coins[i], coins, i);
            }
            return result;
        }
    }

    /**
     * 方法：动态规划
     * <p>
     * 十分钟看答案 十分钟看答案 十分钟看答案 十分钟 十分钟 十分钟
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;

            for (int coin : coins) {
                for (int x = coin; x < amount + 1; ++x) {
                    dp[x] += dp[x - coin];
                }
            }
            return dp[amount];
        }
    }

    /**
     * 结果是排列数，而不是组合数
     * <p>
     * 也就是代码会把1,2和2,1当做两种情况
     * <p>
     * 作者：xu-zhou-geng
     * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            //枚举金额
            for (int j = 1; j <= amount; j++) {
                //枚举硬币
                for (int coin : coins) {
                    if (j < coin) {
                        // coin不能大于amount
                        continue;
                    }
                    dp[j] += dp[j - coin];
                }
            }
            return dp[amount];
        }
    }

    /**
     * 1维状态数组不够 用2维，3维，4维
     * <p>
     * 作者：xu-zhou-geng
     * 链接：https://leetcode-cn.com/problems/coin-change-2/solution/ling-qian-dui-huan-iihe-pa-lou-ti-wen-ti-dao-di-yo/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        /**
         * 不仅记录金额i，还要记录k
         * <p>
         * 正确的子问题定义应该是，problem(k,i) = problem(k-1, i) + problem(k, i-k)
         * <p>
         * 状态数组就是DP[k][i], 即前k个硬币凑齐金额i的组合数。
         * <p>
         * 即前k个硬币凑齐金额i的组合数等于前k-1个硬币凑齐金额i的组合数加上在原来i-k的基础上使用硬币的组合数。
         * <p>
         * 说的更加直白一点，那就是用前k的硬币凑齐金额i，要分为两种情况开率，一种是没有用前k-1个硬币就凑齐了，
         * <p>
         * 一种是前面已经凑到了i-k，现在就差第k个硬币了。
         *
         * @param amount
         * @param coins
         * @return
         */
        public int change(int amount, int[] coins) {
            int K = coins.length + 1;
            int I = amount + 1;
            int[][] DP = new int[K][I];
            //初始化数组
            for (int k = 0; k < K; k++) {
                for (int i = 0; i < I; i++) {
                    DP[k][i] = 0;
                }
            }
            //初始化基本状态
            for (int k = 0; k < coins.length + 1; k++) {
                DP[k][0] = 1;
            }
            for (int k = 1; k <= coins.length; k++) {
                for (int i = 1; i <= amount; i++) {
                    if (i >= coins[k - 1]) {
                        DP[k][i] = DP[k][i - coins[k - 1]] + DP[k - 1][i];
                    } else {
                        DP[k][i] = DP[k - 1][k];
                    }
                }
            }
            return DP[coins.length][amount];
        }
    }

    ;


}
