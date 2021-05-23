package com.leetcode.tag.contest.six;

/**
 * 5765. 跳跃游戏 VII
 */
public class CanReach {
    class Solution {
        public boolean canReach(String s, int minJump, int maxJump) {
            boolean[] dp = new boolean[s.length()];
            dp[0] = true;

            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (s.charAt(j) == '0' && (j + minJump <= i && i <= Math.min(j + maxJump, s.length() - 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }
}
