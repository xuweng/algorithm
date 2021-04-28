package com.leetcode.tag.must2.two;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 */
public class RemoveKdigits {
    /**
     * 方法一：贪心 + 单调栈
     * <p>
     * 若要使得剩下的数字最小，需要保证靠前的数字尽可能小
     * <p>
     * 得出「删除一个数字」的贪心策略
     */
    class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            int length = num.length();
            for (int i = 0; i < length; ++i) {
                char digit = num.charAt(i);
                while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(digit);
            }

            for (int i = 0; i < k; ++i) {
                deque.pollLast();
            }

            StringBuilder ret = new StringBuilder();
            boolean leadingZero = true;
            while (!deque.isEmpty()) {
                char digit = deque.pollFirst();
                if (leadingZero && digit == '0') {
                    continue;
                }
                leadingZero = false;
                ret.append(digit);
            }
            return ret.length() == 0 ? "0" : ret.toString();
        }
    }
}
