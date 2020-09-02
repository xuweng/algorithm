package com.leetcode.tag.daily.two;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * <p>
 * 直接看题解
 * <p>
 * 直接看题解
 */
public class IsNumber {
    class Solution {
        public boolean isNumber(String s) {
            return true;
        }
    }

    /**
     * 方法一：确定有限状态自动机
     * <p>
     * 这个自动机处于「初始状态」。随后，它顺序地读取字符串中的每一个字符，并根据当前状态和读入的字符，
     * <p>
     * 按照某个事先约定好的「转移规则」，从当前状态转移到下一个状态；当状态转移完成后，它就读取下一个字符。
     * <p>
     * 当字符串全部读取完毕后，如果自动机处于某个「接受状态」，则判定该字符串「被接受」；否则，判定该字符串「被拒绝」
     * <p>
     * 一个自动机，总能够回答某种形式的「对于给定的输入字符串 S，判断其是否满足条件 P」的问题。在本题中，条件 P 即为「构成合法的表示数值的字符串」。
     * <p>
     * 自动机驱动的编程，可以被看做一种暴力枚举方法的延伸：它穷尽了在任何一种情况下，对应任何的输入，需要做的事情。
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/biao-shi-shu-zhi-de-zi-fu-chuan-by-leetcode-soluti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution1 {
        public boolean isNumber(String s) {
            Map<State, Map<CharType, State>> transfer = new HashMap<>(64);
            Map<CharType, State> initialMap = new HashMap<CharType, State>(64) {{
                put(CharType.CHAR_SPACE, State.STATE_INITIAL);
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
            }};
            transfer.put(State.STATE_INITIAL, initialMap);
            Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            }};
            transfer.put(State.STATE_INT_SIGN, intSignMap);
            Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_POINT, State.STATE_POINT);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_INTEGER, integerMap);
            Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_POINT, pointMap);
            Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }};
            transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
            Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_FRACTION, fractionMap);
            Map<CharType, State> expMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            }};
            transfer.put(State.STATE_EXP, expMap);
            Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            }};
            transfer.put(State.STATE_EXP_SIGN, expSignMap);
            Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
            Map<CharType, State> endMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_END, endMap);

            int length = s.length();
            State state = State.STATE_INITIAL;

            for (int i = 0; i < length; i++) {
                CharType type = toCharType(s.charAt(i));
                if (!transfer.get(state).containsKey(type)) {
                    return false;
                } else {
                    state = transfer.get(state).get(type);
                }
            }
            return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
        }

        public CharType toCharType(char ch) {
            if (ch >= '0' && ch <= '9') {
                return CharType.CHAR_NUMBER;
            } else if (ch == 'e' || ch == 'E') {
                return CharType.CHAR_EXP;
            } else if (ch == '.') {
                return CharType.CHAR_POINT;
            } else if (ch == '+' || ch == '-') {
                return CharType.CHAR_SIGN;
            } else if (ch == ' ') {
                return CharType.CHAR_SPACE;
            } else {
                return CharType.CHAR_ILLEGAL;
            }
        }

        enum State {
            STATE_INITIAL,
            STATE_INT_SIGN,
            STATE_INTEGER,
            STATE_POINT,
            STATE_POINT_WITHOUT_INT,
            STATE_FRACTION,
            STATE_EXP,
            STATE_EXP_SIGN,
            STATE_EXP_NUMBER,
            STATE_END,
        }

        enum CharType {
            CHAR_NUMBER,
            CHAR_EXP,
            CHAR_POINT,
            CHAR_SIGN,
            CHAR_SPACE,
            CHAR_ILLEGAL,
        }
    }

}
