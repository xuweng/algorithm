package com.leetcode.tag.some;

/**
 * 7. 整数反转
 */
public class Reverse {
    class Solution {
        public int reverse(int x) {
            String s = String.valueOf(Math.abs(x));
            int length = s.length() - 1;
            while (length >= 0 && s.charAt(length) == '0') {
                length--;
            }
            StringBuilder temp = new StringBuilder();
            for (int i = length; i >= 0; i--) {
                temp.append(s.charAt(i));
            }

            return x < 0 ? -Integer.parseInt(temp.toString()) : Integer.parseInt(temp.toString());
        }
    }
}
