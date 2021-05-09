package com.leetcode.tag.must3.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
        List<String> result = new ArrayList<>();
        Deque<Character> deque = new LinkedList<>();

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
                use[i] = true;
                deque.offerLast(chars[i]);

                dfs(chars);

                deque.pollLast();
                use[i] = false;
            }
        }
    }
}
