package com.leetcode.tag.binarysearch.one;

import java.util.stream.IntStream;

/**
 * 面试题 10.05. 稀疏数组搜索
 */
public class FindString {
    class Solution {
        public int findString(String[] words, String s) {
            if (words == null || words.length == 0 || s == null) {
                return -1;
            }
            return IntStream.range(0, words.length).filter(i -> words[i].equals(s)).findFirst().orElse(-1);
        }
    }
}
