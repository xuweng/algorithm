package com.leetcode.tag.daily.four;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 127. 单词接龙
 */
public class LadderLength {
    class Solution {
        int max;
        Set<String> set = new HashSet<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return max;
        }

        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                max = Math.max(max, count);
                return;
            }
            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
            set.remove(beginWord);
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(beginWord)).collect(Collectors.toList());
        }

        private boolean check(String s, String s1) {
            if (s.length() != s1.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    count++;
                }
            }
            return count <= 1;
        }
    }
}
