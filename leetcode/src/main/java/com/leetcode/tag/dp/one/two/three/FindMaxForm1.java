package com.leetcode.tag.dp.one.two.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 * <p>
 * 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉
 * <p>
 * 递归树 递归树 递归树 递归树
 * <p>
 * 限制容量 限制容量 限制容量 限制容量 限制容量 限制容量
 * <p>
 * 容量累加 容量累加 容量累加 容量累加
 */
public class FindMaxForm1 {
    /**
     * 子集累加计数 子集累加计数 子集累加计数
     * <p>
     * 不是这样做 不是这样做 不是这样做
     */
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            Map<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0; i < strs.length; i++) {
                Integer[] integers = map.getOrDefault(i, new Integer[2]);
                int count0 = 0;
                int count1 = 0;
                String str = strs[i];
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '0') {
                        count0++;
                    } else {
                        count1++;
                    }
                }
                integers[0] = count0;
                integers[1] = count1;
            }

            int[] dp = new int[strs.length];
            Integer[] integers = map.get(0);
            dp[0] = (integers[0] <= m && integers[1] <= n) ? 1 : 0;
            for (int i = 1; i < strs.length; i++) {
                Integer[] integers2 = map.get(i);
                for (int j = 0; j < i; j++) {
                    Integer[] integers1 = map.get(j);
                }
            }
            return 0;
        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 这道题和经典的背包问题很类似，不同的是在背包问题中，我们只有一种容量，而在这道题中，
         * <p>
         * 我们有 0 和 1 两种容量。每个物品（字符串）需要分别占用 0 和 1 的若干容量，并且所有物品的价值均为 1。因此我们可以使用二维的动态规划。
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/ones-and-zeroes/solution/yi-he-ling-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param strs
         * @param m
         * @param n
         * @return
         */
        public int findMaxForm(String[] strs, int m, int n) {
            //用 dp(i, j) 表示使用 i 个 0 和 j 个 1，最多能拼出的字符串数目
            int[][] dp = new int[m + 1][n + 1];
            for (String s : strs) {
                int[] count = countzeroesones(s);
                for (int zeroes = m; zeroes >= count[0]; zeroes--) {
                    for (int ones = n; ones >= count[1]; ones--) {
                        dp[zeroes][ones] = Math.max(1 + dp[zeroes - count[0]][ones - count[1]], dp[zeroes][ones]);
                    }
                }
            }
            return dp[m][n];
        }

        /**
         * 01计数 01计数 01计数 01计数
         *
         * @param s
         * @return
         */
        public int[] countzeroesones(String s) {
            int[] c = new int[2];
            for (int i = 0; i < s.length(); i++) {
                c[s.charAt(i) - '0']++;
            }
            return c;
        }
    }

    /**
     * 作者：dong-men
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-0-1bei-bao-wen-ti-labuladongdong-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int findMaxForm(String[] strs, int m, int n) {
            int strsNum = strs.length;
            //dp[i][j][k]的定义如下：
            //若只使用前i个物品，当背包容量为j个0，k个1时，能够容纳的最多字符串数。
            int[][][] dp = new int[strsNum + 1][m + 1][n + 1];

            // base case为dp[0][..][..] = 0, dp[..][0][0] = 0。
            // 因为如果不使用任何一个字符串，则背包能装的字符串数就为0；如果背包对0，1的容量都为0，它能装的字符串数也为0。
            for (int i = 1; i <= strsNum; i++) {
                int[] cnt = count(strs[i - 1]);

                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (cnt[0] > j || cnt[1] > k) {
                            //如果你不能把这第 i 个物品装入背包（等同于容量不足，装不下去）
                            dp[i][j][k] = dp[i - 1][j][k];
                        } else {
                            //如果你可以把这第 i 个物品装入了背包(此时背包容量是充足的，因此要选择装或者不装)
                            // Max函数里的两个式子，分别是装和不装strs[i]的字符串数量
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - cnt[0]][k - cnt[1]] + 1);
                        }
                    }
                }
            }

            return dp[strsNum][m][n];
        }


        // cnt[0] = zeroNums, cnt[1] = oneNums
        public int[] count(String str) {
            int[] cnt = new int[2];
            for (char c : str.toCharArray()) {
                cnt[c - '0']++;
            }
            return cnt;
        }
    }


}
