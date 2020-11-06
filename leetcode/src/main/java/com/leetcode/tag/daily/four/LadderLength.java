package com.leetcode.tag.daily.four;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 127. 单词接龙
 */
public class LadderLength {
    static class Solution {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Set<String> memo = new HashSet<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                return;
            }
            if (memo.contains(beginWord)) {
                return;
            }
            memo.add(beginWord);

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
            set.remove(beginWord);
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
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
            return count == 1;
        }
    }

    class Solution1 {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private void dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                memo.put(beginWord, min);
                return;
            }
            if (memo.containsKey(beginWord) && memo.get(beginWord) <= count) {
                return;
            }
            memo.put(beginWord, count);

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            for (String string : strings) {
                dfs(string, endWord, wordList, count + 1);
            }
            set.remove(beginWord);
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
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
            return count == 1;
        }
    }

    static class Solution2 {
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 1);

            return min == Integer.MAX_VALUE ? 0 : min;
        }

        /**
         * 重复计算
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @param count
         */
        private int dfs(String beginWord, String endWord, List<String> wordList, int count) {
            if (beginWord.equals(endWord)) {
                min = Math.min(min, count);
                memo.put(beginWord, 0);
                return 0;
            }
            if (memo.containsKey(beginWord)) {
                if (memo.get(beginWord) != Integer.MAX_VALUE) {
                    min = Math.min(min, count + memo.get(beginWord));
                }
                return memo.get(beginWord);
            }

            set.add(beginWord);
            List<String> strings = getList(beginWord, wordList);
            // beginWord到endWord的最小距离
            int result = Integer.MAX_VALUE;
            for (String string : strings) {
                int d = dfs(string, endWord, wordList, count + 1);
                if (d == Integer.MAX_VALUE) {
                    // 到不了终点
                    continue;
                }
                result = Math.min(result, d + 1);
            }
            set.remove(beginWord);
            memo.put(beginWord, result);
            return result;
        }

        private List<String> getList(String beginWord, List<String> wordList) {
            return wordList.stream().filter(s -> check(beginWord, s) && !set.contains(s)).collect(Collectors.toList());
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
            return count == 1;
        }
    }
}
