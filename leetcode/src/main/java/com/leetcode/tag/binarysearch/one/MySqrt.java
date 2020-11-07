package com.leetcode.tag.binarysearch.one;

/**
 * 69. x 的平方根
 */
public class MySqrt {
    class Solution {
        public int mySqrt(int x) {
            return (int) bs(x, 0, x);
        }

        private long bs(int x, long left, long right) {
            // 越界才是递归终止条件
            if (left > right) {
                // 取较小值
                return right;
            }
            long mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid > x) {
                return bs(x, left, mid - 1);
            } else {
                return bs(x, mid + 1, right);
            }
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int mySqrt(int x) {
            int left = 0, right = x, ans = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if ((long) mid * mid <= x) {
                    ans = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }

}
