package com.jianzi.offer.study.stacks;

import java.util.Stack;

/**
 * 栈
 */
public class Stacks {
    //stack1用来入队
    private static final Stack<Integer> stack1 = new Stack<Integer>();
    //stack2用来出队,存放最早的元素
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
        //stack2一定为空才入队,使最先的元素出队,防止被覆盖
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
