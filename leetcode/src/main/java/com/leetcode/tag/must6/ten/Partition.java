package com.leetcode.tag.must6.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {
    class Solution {
        List<List<String>> result = new ArrayList<>();
        List<String> stack = new ArrayList<>();
        boolean[][] dp;

        public List<List<String>> partition(String s) {
            if (s == null || s.isEmpty()) {
                return result;
            }
            dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            for (int i = s.length() - 2; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                    if (j > i + 1) {
                        dp[i][j] = dp[i][j] && dp[i + 1][j - 1];
                    }
                }
            }
            dfs(s, 0);

            return result;
        }

        private void dfs(String s, int index) {
            if (index >= s.length()) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (dp[index][i]) {
                    stack.add(s.substring(index, i + 1));

                    dfs(s, i + 1);

                    stack.remove(stack.size() - 1);
                }
            }
        }
    }
}
