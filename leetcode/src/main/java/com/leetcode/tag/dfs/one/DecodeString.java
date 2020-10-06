package com.leetcode.tag.dfs.one;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

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
        //只能按照顺序解析.不能截取.
        int current;

        public String decodeString(String s) {
            src = s;
            current = 0;
            return getString();
        }

        /**
         * 用递归解析[]里面的string
         * <p>
         * 2[a2[bc]]
         * <p>
         * 没有递归参数
         * <p>
         * 全局变量取代递归参数.
         * <p>
         * 递归参数太麻烦.全局变量厉害.
         *
         * @return
         */
        public String getString() {
            //终止条件
            //遇到]就做一次计算
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
                // 用递归解析[]里面的string
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

    /**
     * 算法错误
     * <p>
     * 用示例来理解代码
     * <p>
     * 3[a]2[bc].不通过.
     */
    class Solution2 {
        /**
         * 用递归解析[]里面的string
         * <p>
         * 测试用例
         * <p>
         * 2[a2[bc]]
         * <p>
         * 3[a]2[bc]
         * <p>
         * 没有递归参数
         * <p>
         * 全局变量取代递归参数.
         * <p>
         * 递归参数太麻烦.全局变量厉害.
         *
         * @return
         */
        public String decodeString(String s) {
            //终止条件
            if (!s.contains("[") || !s.contains("]")) {
                return s;
            }

            StringBuilder stringBuilder = new StringBuilder();
            if (Character.isDigit(s.charAt(0))) {
                // 解析 Digits
                int repTime = getDigits(s);
                // 用递归解析[]里面的string
                String str = decodeString(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")));
                // 构造字符串
                while (repTime-- > 0) {
                    stringBuilder.append(str);
                }
                return stringBuilder.toString();
            }
            // 解析 Char
            int index = getLetterIndex(s);

            return s.substring(0, index) + decodeString(s.substring(index));
        }

        public int getLetterIndex(String s) {
            int i = 0;
            while (i < s.length() && Character.isLetter(s.charAt(i))) {
                i++;
            }
            return i;
        }

        public int getDigits(String s) {
            int ret = 0;
            for (int i = 0; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                ret = ret * 10 + s.charAt(i) - '0';
            }
            return ret;
        }
    }

    /**
     * 数字存放在数字栈，字符串存放在字符串栈，遇到右括号时候弹出一个数字栈，字母栈弹到左括号为止.
     */
    class S {
        public String decodeString(String s) {
            StringBuffer ans = new StringBuffer();
            Stack<Integer> multiStack = new Stack<>();
            Stack<StringBuffer> ansStack = new Stack<>();
            int multi = 0;
            for (char c : s.toCharArray()) {
                if (Character.isDigit(c)) {
                    multi = multi * 10 + c - '0';
                } else if (c == '[') {
                    ansStack.add(ans);
                    multiStack.add(multi);
                    ans = new StringBuffer();
                    multi = 0;
                } else if (Character.isAlphabetic(c)) {
                    ans.append(c);
                } else {
                    StringBuffer ansTmp = ansStack.pop();
                    int tmp = multiStack.pop();
                    for (int i = 0; i < tmp; i++) {
                        ansTmp.append(ans);
                    }
                    ans = ansTmp;
                }
            }
            return ans.toString();
        }
    }

    /**
     * 解法一：辅助栈法
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution3 {
        public String decodeString(String s) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            LinkedList<Integer> stackMulti = new LinkedList<>();
            LinkedList<String> stackRes = new LinkedList<>();
            for (char c : s.toCharArray()) {
                if (c == '[') {
                    stackMulti.addLast(multi);
                    stackRes.addLast(res.toString());
                    multi = 0;
                    res = new StringBuilder();
                } else if (c == ']') {
                    StringBuilder tmp = new StringBuilder();
                    int curMulti = stackMulti.removeLast();
                    for (int i = 0; i < curMulti; i++) {
                        tmp.append(res);
                    }
                    res = new StringBuilder(stackRes.removeLast() + tmp);
                } else if (c >= '0' && c <= '9') {
                    multi = multi * 10 + Integer.parseInt(c + "");
                } else {
                    res.append(c);
                }
            }
            return res.toString();
        }
    }

    /**
     * 解法二：递归法
     * <p>
     * 总体思路与辅助栈法一致，不同点在于将 [ 和 ] 分别作为递归的开启与终止条件：
     * <p>
     * 当 s[i] == ']' 时，返回当前括号内记录的 res 字符串与 ] 的索引 i （更新上层递归指针位置）；
     * 当 s[i] == '[' 时，开启新一层递归，记录此 [...] 内字符串 tmp 和递归后的最新索引 i，并执行 res + multi * tmp 拼接字符串。
     * 遍历完毕后返回 res。
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution4 {
        public String decodeString(String s) {
            return dfs(s, 0)[0];
        }

        /**
         * @param s
         * @param i 下标
         * @return
         */
        private String[] dfs(String s, int i) {
            StringBuilder res = new StringBuilder();
            int multi = 0;
            while (i < s.length()) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    multi = multi * 10 + Integer.parseInt(String.valueOf(s.charAt(i)));
                } else if (s.charAt(i) == '[') {
                    String[] tmp = dfs(s, i + 1);
                    i = Integer.parseInt(tmp[0]);
                    while (multi > 0) {
                        res.append(tmp[1]);
                        multi--;
                    }
                } else if (s.charAt(i) == ']') {
                    return new String[]{String.valueOf(i), res.toString()};
                } else {
                    res.append(s.charAt(i));
                }
                i++;
            }
            return new String[]{res.toString()};
        }
    }

}
