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

        public String build(String str) {
            StringBuilder ret = new StringBuilder();
            int length = str.length();
            for (int i = 0; i < length; ++i) {
                char ch = str.charAt(i);
                if (ch != '#') {
                    ret.append(ch);
                } else {
                    if (ret.length() > 0) {
                        ret.deleteCharAt(ret.length() - 1);
                    }
                }
            }
            return ret.toString();
        }
    }

}
