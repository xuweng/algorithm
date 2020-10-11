package com.leetcode.tag.daily.three;

/**
 * 344. 反转字符串
 * <p>
 * 十分钟.一题多刷.遗忘曲线.
 * <p>
 * 第一维是区间.第二维是和.数组越界.
 */
public class ReverseString {
    class Solution {
        public void reverseString(char[] s) {
            reverseString(s, 0, s.length - 1);
        }

        public void reverseString(char[] s, int low, int high) {
            if (s == null || low >= high) {
                return;
            }
            reverseString(s, low + 1, high - 1);
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
        }
    }

    /**
     * 方法一：双指针
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public void reverseString(char[] s) {
            int n = s.length;
            int left = 0, right = n - 1;
            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                ++left;
                --right;
            }
        }
    }

}
