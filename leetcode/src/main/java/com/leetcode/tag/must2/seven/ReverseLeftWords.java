package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class ReverseLeftWords {
    class Solution {
        public String reverseLeftWords(String s, int n) {
            return s.substring(n) + s.substring(0, n);
        }
    }
}
