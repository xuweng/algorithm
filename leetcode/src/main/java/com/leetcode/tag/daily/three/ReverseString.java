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
}
