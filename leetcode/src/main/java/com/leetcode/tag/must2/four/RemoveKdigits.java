package com.leetcode.tag.must2.four;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 */
public class RemoveKdigits {
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            for (int i = 0; i < num.length(); i++) {
                while (!deque.isEmpty() && k > 0 && deque.peekLast() > num.charAt(i)) {
                    deque.pollLast();
                    k--;
                }
                if (deque.isEmpty() && num.charAt(i) == '0') {
                    continue;
                }
                deque.offerLast(num.charAt(i));
            }
            while (k > 0) {
                deque.pollLast();
                k--;
            }
            StringBuilder stringBuilder = new StringBuilder();
            while (!deque.isEmpty()) {
                stringBuilder.append(deque.pollFirst());
            }

            return stringBuilder.toString();
        }
    }
}
