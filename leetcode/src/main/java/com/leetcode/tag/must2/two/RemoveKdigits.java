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
            // 单调递增栈
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

            // 删除了 m 个数字且 m<k，这种情况下我们需要从序列尾部删除额外的 k-m 个数字
            for (int i = 0; i < k; ++i) {
                // 还有剩余删除次数 不断删除栈顶元素
                deque.pollLast();
            }

            // 最终，从栈底到栈顶的答案序列即为最小数。
            // 考虑到栈的特点是后进先出，如果通过栈实现，则需要将栈内元素依次弹出然后进行翻转才能得到最小数。
            // 为了避免翻转操作，可以使用双端队列代替栈的实现。
            StringBuilder ret = new StringBuilder();
            boolean leadingZero = true;
            while (!deque.isEmpty()) {
                // 队首出栈
                char digit = deque.pollFirst();
                // 最终的数字序列存在前导零，我们要删去前导零
                if (leadingZero && digit == '0') {
                    continue;
                }
                leadingZero = false;
                ret.append(digit);
            }
            // 如果最终数字序列为空，我们应该返回 0
            return ret.length() == 0 ? "0" : ret.toString();
        }
    }
}
