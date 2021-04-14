package com.leetcode.tag.must.eight;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class WordBreak {
    /**
     * s1: s[0..j-1]
     * <p>
     * s2：s[j..i-1]
     * <p>
     * s1和s2都合法 整个字符串都合法
     */
    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            // 长度为i是否合法 不是下标
            boolean[] dp = new boolean[s.length() + 1];
            // 初始化
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null) {
                return false;
            }
            if (s.isEmpty()) {
                return wordDict.isEmpty();
            }
            Set<String> collect = new HashSet<>(wordDict);
            // 下标
            boolean[] dp = new boolean[s.length()];
            for (int i = 0; i < s.length(); i++) {
                if (collect.contains(s.substring(0, i + 1))) {
                    dp[i] = true;
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    if (dp[j] && collect.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }
}
