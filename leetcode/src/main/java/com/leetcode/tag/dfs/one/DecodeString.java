package com.leetcode.tag.dfs.one;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 394. 字符串解码
 */
public class DecodeString {
    /**
     * 方法一：栈操作
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        int current;

        /**
         * 好多细节处理
         * <p>
         * 遇到数字、字母、[都入栈
         * <p>
         * 遇到]出栈
         * <p>
         * 2[a2[bc]]
         *
         * @param s
         * @return
         */
        public String decodeString(String s) {
            LinkedList<String> stk = new LinkedList<>();
            while (current < s.length()) {
                char cur = s.charAt(current);
                //遇到数字、字母、[都入栈
                //遇到]出栈
                if (Character.isDigit(cur)) {
                    // 获取一个数字并进栈
                    String digits = getDigits(s);
                    stk.addLast(digits);
                } else if (Character.isLetter(cur) || cur == '[') {
                    // 获取一个字母或者[并进栈
                    stk.addLast(String.valueOf(s.charAt(current++)));
                } else {
                    //处理]
                    ++current;
                    LinkedList<String> sub = new LinkedList<>();
                    while (!"[".equals(stk.peekLast())) {
                        sub.addLast(stk.removeLast());
                    }
                    Collections.reverse(sub);
                    // 左括号出栈
                    stk.removeLast();
                    // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                    int repTime = Integer.parseInt(stk.removeLast());
                    String string = getString(sub);
                    StringBuilder stringBuilder = new StringBuilder();
                    // 构造字符串
                    while (repTime-- > 0) {
                        stringBuilder.append(string);
                    }
                    // 将构造好的字符串入栈
                    stk.addLast(stringBuilder.toString());
                }
            }

            return getString(stk);
        }

        /**
         * 数字字符串
         * <p>
         * "15"
         *
         * @param s
         * @return
         */
        public String getDigits(String s) {
            StringBuilder ret = new StringBuilder();
            while (Character.isDigit(s.charAt(current))) {
                ret.append(s.charAt(current++));
            }
            return ret.toString();
        }

        public String getString(LinkedList<String> v) {
            return String.join("", v);
        }
    }

    /**
     * 方法二：递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/zi-fu-chuan-jie-ma-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        String src;
        //递归传参数麻烦
        //全局下标变量
        int current;

        public String decodeString(String s) {
            src = s;
            current = 0;
            return getString();
        }

        public String getString() {
            if (current == src.length() || src.charAt(current) == ']') {
                // String -> EPS
                return "";
            }

            char cur = src.charAt(current);
            int repTime;
            StringBuilder stringBuilder = new StringBuilder();

            if (Character.isDigit(cur)) {
                // String -> Digits [ String ] String
                // 解析 Digits
                repTime = getDigits();
                // 过滤左括号
                ++current;
                // 解析 String
                String str = getString();
                // 过滤右括号
                ++current;
                // 构造字符串
                while (repTime-- > 0) {
                    stringBuilder.append(str);
                }
            } else if (Character.isLetter(cur)) {
                // String -> Char String
                // 解析 Char
                stringBuilder = new StringBuilder(String.valueOf(src.charAt(current++)));
            }

            return stringBuilder + getString();
        }

        public int getDigits() {
            int ret = 0;
            while (current < src.length() && Character.isDigit(src.charAt(current))) {
                ret = ret * 10 + src.charAt(current++) - '0';
            }
            return ret;
        }
    }
}
