package com.leetcode.tag.binarysearch.one;

/**
 * 面试题 10.05. 稀疏数组搜索
 */
public class FindString {
    class Solution {
        public int findString(String[] words, String s) {
            if (words == null || words.length == 0 || s == null) {
                return -1;
            }
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(s)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
