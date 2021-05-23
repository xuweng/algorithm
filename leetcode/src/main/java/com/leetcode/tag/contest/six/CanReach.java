package com.leetcode.tag.contest.six;

/**
 * 5765. 跳跃游戏 VII
 */
public class CanReach {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            boolean[] dp = new boolean[s.length()];
            dp[0] = true;

            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    if (dp[i] && s.charAt(j) == '0' && (i + minJump <= j && j <= Math.min(i + maxJump, s.length() - 1))) {
                        dp[j] = true;
                        break;
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }
}
