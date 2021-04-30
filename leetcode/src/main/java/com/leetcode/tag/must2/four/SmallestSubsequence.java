package com.leetcode.tag.must2.four;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1081. 不同字符的最小子序列
 */
public class SmallestSubsequence {
    class Solution {
        public String smallestSubsequence(String s) {
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
                while (!deque.isEmpty() && deque.peekLast() > s.charAt(i) && i < ints[deque.peekLast() - 'a']) {
                    Character character = deque.pollLast();
                    is[character - 'a'] = false;
                }
                deque.offerLast(s.charAt(i));
                is[s.charAt(i) - 'a'] = true;
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollFirst());
            }

            return stringBuilder.toString();
        }
    }
}
