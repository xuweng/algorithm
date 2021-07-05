package com.leetcode.tag.must6.ten;

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
        char[] chars;
        boolean[] used;

        public String[] permutation(String s) {
            if (s == null || s.isEmpty()) {
                return new String[0];
            }
            chars = s.toCharArray();
            used = new boolean[s.length()];
            // 排序去重
            Arrays.sort(chars);

            dfs();

            return result.toArray(new String[0]);
        }

        private void dfs() {
            if (stack.size() == chars.length) {
                String s = stack.stream().map(String::valueOf).collect(Collectors.joining());
                result.add(s);
                return;
            }
            for (int i = 0; i < chars.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(chars[i]);

                dfs();

                used[i] = false;
                stack.remove(stack.size() - 1);
            }
        }
    }
}
