package com.leetcode.tag.backtracking.two;

import java.util.*;

/**
 * 140. 单词拆分 II
 * <p>
 * j i-j
 */
public class WordBreak {
    class Solution {
        Deque<String> deque = new LinkedList<>();
        List<String> result = new ArrayList<>();
        HashSet<String> set;

        public List<String> wordBreak(String s, List<String> wordDict) {
            set = new HashSet<>(wordDict);

            back(s, 0);

            return result;
        }

        private void back(String s, int index) {
            if (index >= s.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s1 : deque) {
                    stringBuilder.append(s1);
                }
                result.add(stringBuilder.toString());
                return;
            }
            for (int i = index; i < s.length(); i++) {
                String substring = s.substring(index, i + 1);
                if (!set.contains(substring)) {
                    continue;
                }
                deque.offerLast(i == s.length() - 1 ? substring : substring + " ");
                // 下一层递归
                back(s, i + 1);
                deque.pollLast();
            }
        }
    }
}
