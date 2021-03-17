package com.leetcode.tag.some;

/**
 * 9. 回文数
 */
public class IsPalindrome {
    class Solution {
        public boolean isPalindrome(int x) {
            String s = String.valueOf(x);
            char[] chars = s.toCharArray();

            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    return false;
                }

                left++;
                right--;
            }

            return true;
        }
    }
}
