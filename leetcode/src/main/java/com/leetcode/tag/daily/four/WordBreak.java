package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 140. 单词拆分 II
 */
public class WordBreak {
    class Solution {
        Set<String> set;
        List<String> result = new ArrayList<>();

        public List<String> wordBreak(String s, List<String> wordDict) {
            set = new HashSet<>(wordDict);

            dfs(s, 0, "");

            return result;
        }

        private void dfs(String s, int index, String temp) {
            if (index >= s.length()) {
                result.add(temp.substring(0, temp.length() - 1));
                return;
            }
            for (int i = index; i < s.length(); i++) {
                String str = s.substring(index, i + 1);
                if (!set.contains(str)) {
                    continue;
                }
                dfs(s, i + 1, temp + str + " ");
            }
        }
    }
}
