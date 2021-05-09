package com.leetcode.tag.must3.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 38. 字符串的排列
 * <p>
 * 归并 归并 归并
 * <p>
 * 快排 快排 快排
 */
public class Permutation {
    class Solution {
        boolean[] use;
        Set<String> result = new HashSet<>();
        List<Character> deque = new ArrayList<>();

        public String[] permutation(String s) {
            use = new boolean[s.length()];
            char[] chars = s.toCharArray();

            dfs(chars);

            return result.toArray(new String[0]);
        }

        private void dfs(char[] chars) {
            if (deque.size() == chars.length) {
                String s = deque.stream().map(String::valueOf).collect(Collectors.joining());

                result.add(s);
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (use[i]) {
                    continue;
                }
                // "suvyls"
                // 去重
                if (i > 0 && chars[i] == chars[i - 1] && !use[i - 1]) {
                    continue;
                }
                use[i] = true;
                deque.add(chars[i]);

                dfs(chars);

                deque.remove(deque.size() - 1);
                use[i] = false;
            }
        }
    }

    class Solution1 {
        public String[] permutation(String s) {

            boolean[] used = new boolean[s.length()];
            Set<String> result = new HashSet<>();

            backTrack(s, used, "", result);

            return result.toArray(new String[0]);
        }

        private void backTrack(String s, boolean[] used, String temp, Set<String> result) {
            if (temp.length() == s.length()) {
                result.add(temp);
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                if (used[i]) {
                    continue;
                }
                // 去重
                if (i > 0 && s.charAt(i - 1) == s.charAt(i) && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                backTrack(s, used, temp + s.charAt(i), result);
                used[i] = false;
            }
        }
    }
}
