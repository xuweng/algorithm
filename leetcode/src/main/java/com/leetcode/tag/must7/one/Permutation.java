package com.leetcode.tag.must7.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 剑指 Offer 38. 字符串的排列
 */
public class Permutation {
    class Solution {
        List<String> result = new ArrayList<>();
        List<Character> stack = new ArrayList<>();
        boolean[] used;

        public String[] permutation(String s) {
            if (s == null || s.isEmpty()) {
                return new String[0];
            }
            used = new boolean[s.length()];
            char[] chars = s.toCharArray();
            // 排序去重
            Arrays.sort(chars);

            dfs(chars);

            return result.toArray(new String[0]);
        }

        private void dfs(char[] chars) {
            if (chars.length == stack.size()) {
                String s = stack.stream().map(String::valueOf).collect(Collectors.joining());
                result.add(s);
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && chars[i - 1] == chars[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(chars[i]);

                dfs(chars);
                used[i] = false;
                stack.remove(stack.size() - 1);
            }
        }
    }
}
