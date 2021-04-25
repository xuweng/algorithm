package com.leetcode.tag.must1.eight;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 946. 验证栈序列
 */
public class ValidateStackSequences {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> deque = new LinkedList<>();
            int i = 0;
            for (int p : popped) {
                deque.push(p);
                while (!deque.isEmpty() && deque.peek() == popped[i]) {
                    deque.pop();
                    i++;
                }
            }

            return deque.isEmpty();
        }
    }
}
