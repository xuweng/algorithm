package com.algorithm.study.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 表达式求值
 */
public class BiaoDaShi {
    //运算符优先级
    private static Map<Character, Integer> operatorPriorityMap = new HashMap<>();

    private static Stack<Double> dateStack = new Stack<>();
    private static Stack<Character> operatorStack = new Stack<>();

    static {
        for (Operation operation : Operation.values()) {
            operatorPriorityMap.put(operation.PIUS.c, operation.PIUS.priority);
        }
    }

    /**
     * 表达式求值
     * <p>
     * 从左向右遍历表达式，当遇到数字，我们就直接压入操作数栈；当遇到运算符，
     * 就与运算符栈的栈顶元素进行比较。如果比运算符栈顶元素的优先级高，就将当前运算符压入栈；
     * 如果比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取 2 个操作数，
     * 然后进行计算，再把计算完的结果压入操作数栈，继续比较。
     *
     * @param exp 表达式
     * @return
     */
    public static Double calcualte(String exp) {
        if (!isExp(exp)) {
            return null;
        }
        operatorStack.push(exp.charAt(1));

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            if (isNumber(c)) {
                //当遇到数字，我们就直接压入操作数栈
                dateStack.push(Double.parseDouble(String.valueOf(c)));
            } else {
                //获取栈顶元素,不删除栈顶元素
                if (operatorPriorityMax(operatorStack.peek(), c)) {
                    //如果比运算符栈顶元素的优先级高，就将当前运算符压入栈
                    operatorStack.push(c);
                } else {
                    //获取栈顶元素,删除栈顶元素
                    dateStack.push(compute(operatorStack.pop(), dateStack.pop(), dateStack.pop()));
                }
            }
        }

        while (!operatorStack.empty()) {
            dateStack.push(compute(operatorStack.pop(), dateStack.pop(), dateStack.pop()));
        }

        return dateStack.pop();
    }

    /**
     * 执行四则运算
     *
     * @param c
     * @param n1
     * @param n2
     * @return
     */
    private static double compute(char c, double n1, double n2) {
        if (Operation.PIUS.c == c) {
            return n2 + n1;
        } else if (Operation.MINUS.c == c) {
            return n2 - n1;
        } else if (Operation.TIMES.c == c) {
            return n2 * n1;
        } else if (Operation.DIVIDE.c == c) {
            return n2 / n1;
        } else {
            throw new RuntimeException("unsupported operator:" + c);
        }
    }


    /**
     * 运算符优先级
     *
     * @param c
     * @param c1
     * @return
     */
    private static boolean operatorPriorityMax(char c, char c1) {
        return operatorPriorityMap.get(c) > operatorPriorityMap.get(c1);
    }

    /**
     * 简单验证表达式
     * <p>
     * 不能包含字母;数字和运算符不能相邻
     *
     * @return
     */
    private static boolean isExp(String exp) {
        Objects.requireNonNull(exp);

        return isNumber(exp.charAt(0)) && isNumber(exp.charAt(exp.length() - 1));
    }

    /**
     * 检查一个String是否为数字
     *
     * @param token
     * @return
     */
    private static boolean isNumber(String token) {
        for (int i = 0; i < token.length(); i++) {
            char ch = token.charAt(i);
            // 跳过小数点
            if (ch == '.') {
                continue;
            }

            if (!isNumber(ch)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 检查一个字符是否为数字
     *
     * @param ch
     * @return
     */
    private static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    /**
     * 加减乘除
     */
    private static enum Operation {
        PIUS('+', 1), MINUS('-', 1),
        TIMES('*', 2), DIVIDE('/', 2),
        LEFT('(', 3), RIGHT(')', 3);

        private char c;
        private int priority;

        Operation(char c) {
            this.c = c;
        }

        Operation(char c, int priority) {
            this.c = c;
            this.priority = priority;
        }
    }
}
