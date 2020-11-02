package com.leetcode.tag.dfs.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 472. 连接词
 */
public class FindAllConcatenatedWordsInADict2 {
    class Solution {
        Set<String> set = new HashSet<>();

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            List<String> result = new ArrayList<>();
            if (words == null || words.length == 0) {
                return result;
            }
            for (String word : words) {
                if (dfs(word, 0, 0)) {
                    result.add(word);
                }
            }

            return result;
        }

        private boolean dfs(String s, int index, int count) {
            if (index >= s.length()) {
                return count > 1;
            }
            for (int i = index; i < s.length(); i++) {
                if (!set.contains(s.substring(index, i + 1))) {
                    continue;
                }
                if (dfs(s, i + 1, count + 1)) {
                    return true;
                }
            }
            return false;
        }
    }
}
