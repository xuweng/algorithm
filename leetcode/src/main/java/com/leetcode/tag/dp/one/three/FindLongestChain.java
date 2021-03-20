package com.leetcode.tag.dp.one.three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 646. 最长数对链
 */
public class FindLongestChain {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }
            Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));

            int[] dp = new int[pairs.length];
            int max = 1;
            for (int i = 0; i < pairs.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (pairs[j][1] < pairs[i][0]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    class Solution1 {
        public int findLongestChain(int[][] pairs) {
            if (pairs == null || pairs.length == 0) {
                return 0;
            }
            Arrays.sort(pairs, Comparator.comparingInt(arr -> arr[0]));

            int result = 0;
            int cur = Integer.MIN_VALUE;
            for (int[] pair : pairs) {
                if (pair[0] > cur) {
                    result++;
                    cur = pair[1];
                }
            }

            return result;
        }
    }
}
