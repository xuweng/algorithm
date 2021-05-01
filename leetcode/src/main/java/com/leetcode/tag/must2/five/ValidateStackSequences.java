package com.leetcode.tag.must2.five;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 */
public class ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> deque = new LinkedList<>();
            int j = 0;
            for (int i : pushed) {
                deque.push(i);
                while (!deque.isEmpty() && deque.peek() == popped[j]) {
                    deque.pop();
                    j++;
                }
            }

            return deque.isEmpty();
        }
    }
}
