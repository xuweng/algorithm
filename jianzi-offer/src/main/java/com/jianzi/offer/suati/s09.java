package com.jianzi.offer.suati;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 */
public class s09 {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (!outStack.isEmpty()) {
            return outStack.pop();
        }

        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }

        if (outStack.isEmpty()) {
            return -1;
        }
        return outStack.pop();
    }
}
