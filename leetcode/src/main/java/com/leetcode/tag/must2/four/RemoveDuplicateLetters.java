package com.leetcode.tag.must2.four;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 316. 去除重复字母
 */
public class RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            Deque<Character> deque = new LinkedList<>();
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ints[s.charAt(i) - 'a'] = i;
            }
            boolean[] is = new boolean[26];
            for (int i = 0; i < s.length(); i++) {
                if (is[s.charAt(i) - 'a']) {
                    continue;
                }
                while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && i < ints[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(s.charAt(i));
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollFirst());
            }

            return stringBuilder.toString();
        }
    }
}
