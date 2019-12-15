package com.algorithm.study.algorithm.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

/**
 * 括号匹配
 */
public class KuoHao {
    //存放左括号
    private static Map<Character, Character> leftMap = new HashMap<>();
    private static Stack<Character> kuoStack = new Stack<>();

    static {
        leftMap.put(Kuo.YUAN.left, Kuo.YUAN.right);
        leftMap.put(Kuo.FANG.left, Kuo.FANG.right);
        leftMap.put(Kuo.HUA.left, Kuo.HUA.right);
    }

    /**
     * 当扫描到左括号时，则将其压入栈中；当扫描到右括号时，从栈顶取出一个左括号。
     * 如果能够匹配，比如“(”跟“)”匹配，“[”跟“]”匹配，“{”跟“}”匹配，则继续扫描剩下的字符串。
     * 如果扫描的过程中，遇到不能配对的右括号，或者栈中没有数据，则说明为非法格式。
     * 当所有的括号都扫描完成之后，如果栈为空，则说明字符串为合法格式；否则，说明有未匹配的左括号，为非法格式。
     *
     * @param str
     * @return
     */
    public static boolean piPei(String str) {
        if (!isStr(str)) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (isLeft(c)) {
                kuoStack.push(c);
            } else {
                if ((leftMap.get(kuoStack.peek()) != c) || kuoStack.isEmpty()) {
                    //不能能够匹配,或者栈中没有数据
                    return false;
                }
                kuoStack.pop();
            }
        }
        //当所有的括号都扫描完成之后，如果栈为空，则说明字符串为合法格式；否则，说明有未匹配的左括号，为非法格式。
        return kuoStack.isEmpty();
    }

    /**
     * 是否是正确的字符串
     *
     * @param str
     * @return
     */
    private static boolean isStr(String str) {
        Objects.requireNonNull(str);
        //第一个是否左括号
        if (!isLeft(str.charAt(0))) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!isLeft(str.charAt(i)) && !isRight(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 左括号
     *
     * @param c
     * @return
     */
    private static boolean isLeft(char c) {
        return (c == Kuo.YUAN.left) || (c == Kuo.FANG.left) || (c == Kuo.HUA.left);
    }

    /**
     * 右括号
     *
     * @param c
     * @return
     */
    private static boolean isRight(char c) {
        return (c == Kuo.YUAN.right) || (c == Kuo.FANG.right) || (c == Kuo.HUA.right);
    }

    private enum Kuo {
        YUAN('(', ')'),
        FANG('[', ']'),
        HUA('{', '}');

        private char left;
        private char right;

        Kuo(char left) {
            this.left = left;
        }

        Kuo(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
}
