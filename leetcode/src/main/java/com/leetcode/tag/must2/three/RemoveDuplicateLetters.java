package com.leetcode.tag.must2.three;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            Deque<Character> deque = new LinkedList<>();
            int[] ints = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                // 字符最后出现的下标 为了删除重复
                ints[s.charAt(i) - 'a'] = i;
            }
            boolean[] visited = new boolean[26];
            for (int i = 0; i < s.length(); i++) {
                if (visited[s.charAt(i) - 'a']) {
                    // 重复出现
                    continue;
                }
                // i < ints[s.charAt(i) - 'a'] i的后面还有相等的字符，可以删除i
                while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && i < ints[s.charAt(i) - 'a']) {
                    Character character = deque.pollLast();
                    visited[character - 'a'] = false;
                }
                deque.offerLast(s.charAt(i));
                visited[s.charAt(i) - 'a'] = true;
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollFirst());
            }

            return stringBuilder.toString();
        }
    }
}
