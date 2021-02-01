package com.leetcode.tag.must.one;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null) {
                return false;
            }
            if (s.isEmpty()) {
                return wordDict.isEmpty();
            }
            Set<String> collect = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (collect.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (collect.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = dp[i] || dp[j];
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }
}
