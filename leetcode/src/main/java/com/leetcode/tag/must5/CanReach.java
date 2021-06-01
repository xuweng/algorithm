package com.leetcode.tag.must5;

import java.util.Arrays;

/**
 * 1871. 跳跃游戏 VII
 */
public class CanReach {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            int[] sum = new int[s.length() + 1];
            int[] dp = new int[s.length() + 1];
            Arrays.fill(dp, 1);
            dp[1] = 0;

            for (int i = 2; i <= s.length(); i++) {
                if (s.charAt(i - 1) == '0') {
                    if (i - minJump >= 1) {
                        int l = Math.max(1, i - maxJump);
                        int r = i - minJump;
                        // [l-1,r-1]
                        dp[i] = sum[r] - sum[l - 1] < r - l + 1 ? 0 : 1;
                    }
                }
                sum[i] = sum[i - 1] + dp[i];
            }

            return dp[s.length()] == 0;
        }
    }
}
