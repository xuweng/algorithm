package com.leetcode.tag.must6.five;

/**
 * 1897. 重新分配字符使所有字符串都相等
 */
public class MakeEqual {
    class Solution {
        public boolean makeEqual(String[] words) {
            int len = words.length;
            int[] charCount = new int[129];
            for (String word : words) {
                // 统计这个字符串数组里每个字符的数量
                for (char c : word.toCharArray()) {
                    charCount[c]++;
                }
            }
            for (int i : charCount) {
                if (i % len != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
