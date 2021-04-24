package com.leetcode.tag.must1.seven;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * <p>
 * 模拟示例理解
 * <p>
 * 并查集 并查集 并查集
 * <p>
 * 最大堆 最大堆 最小堆 最小堆
 */
public class ValidateStackSequences {
    /**
     * 所有的元素一定是按顺序 push 进去的，重要的是怎么 pop 出来？
     * <p>
     * 将 pushed 队列中的每个数都 push 到栈中，同时检查这个数是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来。
     * <p>
     * 最后，检查不是所有的该 pop 出来的值都是 pop 出来了
     */
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int N = pushed.length;
            Deque<Integer> stack = new LinkedList<>();

            int j = 0;
            for (int x : pushed) {
                // 将 pushed 队列中的每个数都 push 到栈中
                stack.push(x);
                while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                    // 检查栈顶是不是 popped 序列中下一个要 pop 的值，如果是就把它 pop 出来
                    stack.pop();
                    j++;
                }
            }

            return stack.isEmpty();
        }
    }
}
