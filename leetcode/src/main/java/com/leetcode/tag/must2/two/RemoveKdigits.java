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
     * <p>
     * 给定一个长度为 n 的数字序列,从左往右找到第一个位置 i（i>0）使得 D_i<D_i-1，并删去D_i-1
     * <p>
     * 如果不存在，说明整个数字序列单调不降，删去最后一个数字即可
     * <p>
     * 每次对整个数字序列执行一次这个策略；删去一个字符后，剩下的 n-1 长度的数字序列就形成了新的子问题，可以继续使用同样的策略，直至删除 k 次
     * <p>
     * 对于每个数字，如果该数字小于栈顶元素，我们就不断地弹出栈顶元素，直到
     * <p>
     * 栈为空
     * 或者新的栈顶元素不大于当前数字
     * 或者我们已经删除了 kk 位数字
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
