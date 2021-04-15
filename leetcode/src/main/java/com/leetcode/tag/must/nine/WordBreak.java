package com.leetcode.tag.must.nine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.isEmpty()) {
                return false;
            }
            Set<String> set = new HashSet<>(wordDict);
            // 长度
            boolean[] dp = new boolean[s.length() + 1];
            // 初始化
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
