package com.jianzi.offer.study.stacks;

import java.util.Stack;

/**
 * 栈
 */
public class Stacks {
    private static final Stack<Integer> stack1 = new Stack<Integer>();
    private static final Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 入队
     * <p>
     * 判满
     *
     * @param value
     */
    public static void appendTail(Integer value) {
        stack1.push(value);
    }

    /**
     * 出队
     * <p>
     * 判空
     *
     * @return
     */
    public static Integer deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            throw new NullPointerException();
        }
        return stack2.pop();
    }
}
