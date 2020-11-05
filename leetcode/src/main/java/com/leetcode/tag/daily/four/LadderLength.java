package com.leetcode.tag.daily.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 127. 单词接龙
 */
public class LadderLength {
    class Solution {
        int max;
        boolean[] visited;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            visited = new boolean[wordList.size()];

            dfs(beginWord, endWord, wordList, 1);

            return max;
        }

        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                max = Math.max(max, count);
                return;
            }
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
        }

        private List<String> getList(String str, List<String> wordList) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < wordList.size(); i++) {
                String s = wordList.get(i);
                if (check(str, s) && !visited[i]) {
                    visited[i] = true;
                    list.add(s);
                }
            }
            return list;
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
