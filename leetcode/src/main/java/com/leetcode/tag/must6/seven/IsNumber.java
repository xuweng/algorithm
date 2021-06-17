package com.leetcode.tag.must6.seven;

import java.util.HashMap;
import java.util.Map;

/**
 * 65. 有效数字
 */
public class IsNumber {
    /**
     * 方法一：确定有限状态自动机
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/valid-number/solution/you-xiao-shu-zi-by-leetcode-solution-298l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution {
        public boolean isNumber(String s) {
            Map<State, Map<CharType, State>> transfer = new HashMap<>();
            Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
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
            }};
            transfer.put(State.STATE_INTEGER, integerMap);
            Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
            }};
            transfer.put(State.STATE_POINT, pointMap);
            Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }};
            transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
            Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
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
            }};
            transfer.put(State.STATE_EXP_NUMBER, expNumberMap);

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
            STATE_END
        }

        enum CharType {
            CHAR_NUMBER,
            CHAR_EXP,
            CHAR_POINT,
            CHAR_SIGN,
            CHAR_ILLEGAL
        }
    }

    /**
     * 编译原理  表驱动法
     * <p>
     * 作者：user8973
     * 链接：https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int make(char c) {
            switch (c) {
                case ' ':
                    return 0;
                case '+':
                case '-':
                    return 1;
                case '.':
                    return 3;
                case 'e':
                    return 4;
                default:
                    if (c >= 48 && c <= 57) {
                        return 2;
                    }
            }
            return -1;
        }

        public boolean isNumber(String s) {
            int state = 0;
            int finals = 0b101101000;
            int[][] transfer = new int[][]{{0, 1, 6, 2, -1},
                    {-1, -1, 6, 2, -1},
                    {-1, -1, 3, -1, -1},
                    {8, -1, 3, -1, 4},
                    {-1, 7, 5, -1, -1},
                    {8, -1, 5, -1, -1},
                    {8, -1, 6, 3, 4},
                    {-1, -1, 5, -1, -1},
                    {8, -1, -1, -1, -1}};
            char[] ss = s.toCharArray();
            for (char c : ss) {
                int id = make(c);
                if (id < 0) {
                    return false;
                }
                state = transfer[state][id];
                if (state < 0) {
                    return false;
                }
            }
            return (finals & (1 << state)) > 0;
        }
    }
}
