package com.leetcode.tag.binarysearch.one;

/**
 * 275. H 指数 II
 * <p>
 * 线段树
 * <p>
 * 树状数组
 */
public class HIndex {
    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/h-index-ii/solution/hzhi-shu-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int hIndex(int[] citations) {
            int idx = 0;
            for (int c : citations) {
                if (c >= citations.length - idx) {
                    return citations.length - idx;
                } else {
                    idx++;
                }
            }
            return 0;
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/h-index-ii/solution/hzhi-shu-ii-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            int pivot, left = 0, right = n - 1;
            while (left <= right) {
                pivot = left + (right - left) / 2;
                if (citations[pivot] == n - pivot) {
                    return n - pivot;
                } else if (citations[pivot] < n - pivot) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }
            return n - left;
        }
    }

    class Solution2 {
        public int hIndex(int[] citations) {
            int n = citations.length;
            for (int h = n; h > 0; h--) {
                if (citations[n - h] >= h) {
                    return h;
                }
            }
            return 0;
        }
    }

}
