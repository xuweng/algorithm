package com.leetcode.tag.daily.four;

/**
 * 844. 比较含退格的字符串
 */
public class BackspaceCompare {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            StringBuilder stringBuilder = new StringBuilder(S);
            StringBuilder s = new StringBuilder(T);

            dfs(stringBuilder, 0);
            dfs(s, 0);

            return stringBuilder.toString().equals(s.toString());
        }

        private void dfs(StringBuilder s, int index) {
            if (index >= s.length() || index == -1 || s.indexOf("#") == -1) {
                return;
            }
            if (s.charAt(index) == '#') {
                s.deleteCharAt(index);
                if (index >= 1) {
                    s.deleteCharAt(index - 1);
                }
                dfs(s, s.indexOf("#"));
            } else {
                dfs(s, index + 1);
            }
        }
    }

    /**
     * 方法一：重构字符串
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean backspaceCompare(String S, String T) {
            return build(S).equals(build(T));
        }

        /**
         * 具体地，我们用栈处理遍历过程，每次我们遍历到一个字符：
         * <p>
         * 如果它是退格符，那么我们将栈顶弹出；
         * <p>
         * 如果它是普通字符，那么我们将其压入栈中。
         *
         * @param str
         * @return
         */
        public String build(String str) {
            StringBuilder ret = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                char ch = str.charAt(i);
                if (ch != '#') {
                    //入栈
                    ret.append(ch);
                } else {
                    if (ret.length() > 0) {
                        //栈顶弹出
                        ret.deleteCharAt(ret.length() - 1);
                    }
                }
            }
            return ret.toString();
        }
    }

    /**
     * 方法二：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/backspace-string-compare/solution/bi-jiao-han-tui-ge-de-zi-fu-chuan-by-leetcode-solu/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1, j = T.length() - 1;
            //定义 skip 表示当前待删除的字符的数量
            int skipS = 0, skipT = 0;

            // 统计#的个数
            // 一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。
            // 因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (S.charAt(i) == '#') {
                        skipS++;
                        i--;
                    } else if (skipS > 0) {
                        skipS--;
                        i--;
                    } else {
                        break;
                    }
                }
                while (j >= 0) {
                    if (T.charAt(j) == '#') {
                        skipT++;
                        j--;
                    } else if (skipT > 0) {
                        skipT--;
                        j--;
                    } else {
                        break;
                    }
                }
                if (i >= 0 && j >= 0) {
                    if (S.charAt(i) != T.charAt(j)) {
                        return false;
                    }
                } else {
                    if (i >= 0 || j >= 0) {
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;
        }
    }

}
