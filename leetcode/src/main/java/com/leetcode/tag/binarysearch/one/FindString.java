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

    class Solution1 {
        public int findString(String[] words, String s) {
            if (words == null || words.length == 0 || s == null) {
                return -1;
            }
            return bs(words, s, 0, words.length - 1);
        }

        private int bs(String[] words, String s, int left, int right) {
            if (left > right) {
                return -1;
            }
            int mid = left + (right - left) / 2;
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                return bs(words, s, mid + 1, right);
            } else {
                return bs(words, s, left, mid - 1);
            }
        }
    }
}
