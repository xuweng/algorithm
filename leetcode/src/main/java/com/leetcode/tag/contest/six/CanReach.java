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
                for (int i = 0; i < j && s.charAt(j) == '0'; i++) {
                    if (dp[i] && (i + minJump <= j && j <= Math.min(i + maxJump, s.length() - 1))) {
                        dp[j] = true;
                        break;
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }

    class Solution1 {
        public boolean canReach(String s, int minJump, int maxJump) {
            int max = 0;

            for (int i = 0; i < s.length() && i <= max; i++) {
                int left = i + minJump;
                int right = Math.min(i + maxJump, s.length() - 1);

                for (int j = left; j <= right; j++) {
                    if (s.charAt(j) == '0') {
                        max = Math.max(max, j);
                    }
                }
                if (max >= s.length() - 1) {
                    return true;
                }
            }

            return false;
        }
    }
}
