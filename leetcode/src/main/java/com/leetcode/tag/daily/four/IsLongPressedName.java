package com.leetcode.tag.daily.four;

/**
 * 925. 长按键入
 * <p>
 * 十分钟.十分钟.十分钟
 */
public class IsLongPressedName {
    /**
     * 方法一：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/long-pressed-name/solution/chang-an-jian-ru-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public boolean isLongPressedName(String name, String typed) {
            int i = 0, j = 0;
            while (j < typed.length()) {
                if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                    // 说明两个字符串存在一对匹配的字符，此时将 i,j 都加 1
                    i++;
                    j++;
                } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                    // 说明存在一次长按键入，此时只将 j 加 1。
                    j++;
                } else {
                    return false;
                }
            }
            return i == name.length();
        }
    }

    class Solution1 {
        public boolean isLongPressedName(String name, String typed) {
            if (name.length() == 0 || typed.length() == 0) {
                return false;
            }
            int i = 0;
            int j = 0;
            while (i < name.length()) {
                char ch = name.charAt(i);
                int count = 0;
                // 计数
                while (i < name.length() && name.charAt(i) == ch) {
                    count++;
                    i++;
                }
                // 计数
                while (j < typed.length() && typed.charAt(j) == ch) {
                    count--;
                    j++;
                }
                if (count > 0) {
                    return false;
                }
            }
            return j == typed.length();
        }
    }

}
