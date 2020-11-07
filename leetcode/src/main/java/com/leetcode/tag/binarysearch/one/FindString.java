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
            // 处理left空格
            while (left <= right && words[left].isEmpty()) {
                left++;
            }
            // 处理right空格
            while (left <= right && words[right].isEmpty()) {
                right--;
            }
            // 处理mid空格
            int mid = left + (right - left) / 2;
            while (mid < right && words[mid].isEmpty()) {
                mid++;
            }
            if (words[mid].equals(s)) {
                return mid;
            } else if (words[mid].compareTo(s) < 0) {
                return bs(words, s, mid + 1, right);
            } else {
                return bs(words, s, left, mid - 1);
            }
        }
    }

    /**
     * 二分搜索+线性查找
     * <p>
     * 作者：MufengYe
     * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci/solution/er-fen-sou-suo-xian-xing-cha-zhao-by-mufengye/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int findString(String[] words, String S) {
            if (words == null || words.length == 0) {
                return -1;
            }
            int left = 0, right = words.length - 1;
            while (left <= right) {
                // 处理left空格
                while (left <= right && words[left].isEmpty()) {
                    left++;
                }
                // 处理right空格
                while (left <= right && words[right].isEmpty()) {
                    right--;
                }
                // 处理mid空格
                int mid = left + (right - left) / 2;
                while (mid < right && words[mid].isEmpty()) {
                    // mid++?
                    // 不是mid--?
                    mid++;
                }

                // bs
                if (words[mid].equals(S)) {
                    return mid;
                } else if (words[mid].compareTo(S) > 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}
