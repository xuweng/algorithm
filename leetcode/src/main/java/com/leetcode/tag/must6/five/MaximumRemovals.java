package com.leetcode.tag.must6.five;

/**
 * 1898. 可移除字符的最大数目
 */
public class MaximumRemovals {
    /**
     * 方法一：二分查找转化为判定问题
     */
    class Solution {
        public int maximumRemovals(String s, String p, int[] removable) {
            int l = 0;
            int r = removable.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (!isSubsequence(s, p, mid, removable)) {
                    // 缩小mid
                    r = mid - 1;
                } else {
                    // 扩大mid
                    l = mid + 1;
                }
            }
            return r + 1;
        }

        /**
         * 判断p是否是s的子串,且不能包含被删除的元素
         */
        public boolean isSubsequence(String s, String p, int k, int[] removable) {
            int m = s.length();
            int n = p.length();
            int i = 0;
            int j = 0;
            // 被删除的前k个元素
            boolean[] state = new boolean[m];
            for (int x = 0; x <= k; x++) {
                state[removable[x]] = true;
            }

            while (i < m && j < n) {
                if (s.charAt(i) == p.charAt(j) && !state[i]) {
                    j++;
                }
                i++;
            }
            return j == n;
        }
    }

    class Solution1 {
        public int maximumRemovals(String s, String p, int[] removable) {
            int left = 0;
            int right = removable.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (isSubsequence(s, p, mid, removable)) {
                    // 满足条件
                    // 扩大mid
                    left = mid + 1;
                } else {
                    // 不满足条件
                    // 缩小mid
                    right = mid - 1;
                }
            }
            return left;
        }

        /**
         * 判断p是否是s的子串,且不能包含被删除的元素
         */
        public boolean isSubsequence(String s, String p, int k, int[] removable) {
            int m = s.length();
            int n = p.length();
            int i = 0;
            int j = 0;
            // 被删除的前k个元素
            boolean[] state = new boolean[m];
            for (int x = 0; x <= k; x++) {
                state[removable[x]] = true;
            }

            while (i < m && j < n) {
                if (s.charAt(i) == p.charAt(j) && !state[i]) {
                    j++;
                }
                i++;
            }
            return j == n;
        }
    }
}
