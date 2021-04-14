package com.leetcode.tag.must.eight;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak {
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length()];
            dp[0] = true;
            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j + 1, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length() - 1];
        }
    }
}
