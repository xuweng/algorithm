package com.leetcode.tag.must6.three;

import java.util.Arrays;

/**
 * 1049. 最后一块石头的重量 II
 */
public class LastStoneWeightII {
    class Solution {
        public int lastStoneWeightII(int[] stones) {
            // sum=s1+s2
            // target=s1-s2
            // sum+target=2*s1
            int sum = Arrays.stream(stones).sum();
            int s = sum / 2;

            int[] dp = new int[s + 1];
            for (int stone : stones) {
                for (int i = s; i >= stone; i--) {
                    dp[i] = Math.max(dp[i], dp[i - stone] + stone);
                }
            }

            return sum - dp[s];
        }
    }
}
