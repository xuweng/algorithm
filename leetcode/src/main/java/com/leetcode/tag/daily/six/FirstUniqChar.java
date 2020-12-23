package com.leetcode.tag.daily.six;

/**
 * 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    class Solution {
        public int firstUniqChar(String s) {
            int[] ints = new int[26];
            for (int i = 0; i < s.length(); i++) {
                ints[s.charAt(i) - 'a']++;
            }
            char c = 0;
            for (int anInt : ints) {
                if (anInt == 1) {
                    c = (char) (anInt + 'a');
                    break;
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    return i;
                }
            }
            return 0;
        }
    }
}
