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
                    if (dp[j] && collect.contains(s.substring(j + 1, i + 1))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length() - 1];
        }
    }

    /**
     * 不仅考虑子问题，还要考虑剩余问题
     * <p>
     * f(i)：考虑 f(j) 和 i-j
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/word-break/solution/dan-ci-chai-fen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
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

}
