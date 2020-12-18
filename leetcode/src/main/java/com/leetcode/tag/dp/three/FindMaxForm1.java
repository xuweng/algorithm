package com.leetcode.tag.dp.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 474. 一和零
 * <p>
 * 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉 感觉
 * <p>
 * 递归树 递归树 递归树 递归树
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

}
