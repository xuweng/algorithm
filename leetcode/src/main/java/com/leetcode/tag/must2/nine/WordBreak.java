package com.leetcode.tag.must2.nine;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 * <p>
 * 结尾 结尾 末尾
 * <p>
 * 单调 单调 单调
 */
public class WordBreak {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> stringSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && stringSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }
}
