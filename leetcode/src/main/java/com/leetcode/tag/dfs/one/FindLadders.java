package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 17.22. 单词转换
 * <p>
 * dp.dp.dp.dp.dp
 * <p>
 * 递归终止条件.递归终止条件.递归终止条件.递归终止条件.
 * <p>
 * 递归终止条件太重要.树形dp.递归终止条件.漂亮代码.
 */
public class FindLadders {
    /**
     * 算法错误
     * <p>
     * 不用按照从左到右的顺序选择
     */
    class Solution {
        List<String> result;
        List<String> stack = new ArrayList<>();

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            dfs(beginWord, endWord, wordList, 0);

            if (result == null) {
                return new ArrayList<>();
            }
            result.add(0, beginWord);

            return result;
        }

        public void dfs(String beginWord, String endWord, List<String> wordList, int start) {
            if (beginWord.equals(endWord)) {
                result = result == null ? new ArrayList<>(stack) : result;
                return;
            }
            for (int i = start; i < wordList.size(); i++) {
                if (!check(beginWord, wordList.get(i))) {
                    continue;
                }
                stack.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList, i + 1);
                stack.remove(stack.size() - 1);
            }
        }

        private boolean check(String beginWord, String str) {
            if (beginWord.length() != str.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }

    /**
     * 超出时间限制
     */
    class Solution1 {
        List<String> result;
        List<String> stack = new ArrayList<>();
        boolean[] used;

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            used = new boolean[wordList.size()];

            dfs(beginWord, endWord, wordList);

            if (result == null) {
                return new ArrayList<>();
            }
            result.add(0, beginWord);

            return result;
        }

        public void dfs(String beginWord, String endWord, List<String> wordList) {
            if (beginWord.equals(endWord)) {
                result = result == null ? new ArrayList<>(stack) : result;
                return;
            }
            for (int i = 0; i < wordList.size(); i++) {
                if (!check(beginWord, wordList.get(i)) || used[i]) {
                    continue;
                }
                used[i] = true;
                stack.add(wordList.get(i));
                dfs(wordList.get(i), endWord, wordList);
                stack.remove(stack.size() - 1);
                used[i] = false;
            }
        }

        private boolean check(String beginWord, String str) {
            if (beginWord.length() != str.length()) {
                return false;
            }
            int count = 0;
            for (int i = 0; i < beginWord.length(); i++) {
                if (beginWord.charAt(i) != str.charAt(i)) {
                    count++;
                }
            }
            return count == 1;
        }
    }
}
