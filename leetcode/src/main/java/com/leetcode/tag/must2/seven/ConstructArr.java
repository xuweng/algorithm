package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 66. 构建乘积数组
 */
public class ConstructArr {
    /**
     * 对角线
     */
    class Solution {
        /**
         * 计算矩阵的对角线的积
         *
         * @param a
         * @return
         */
        public int[] constructArr(int[] a) {
            if (a.length == 0) {
                return new int[0];
            }
            int[] b = new int[a.length];
            b[0] = 1;
            // 计算 B[i] 下三角 各元素的乘积，直接乘入 B[i]
            for (int i = 1; i < a.length; i++) {
                b[i] = b[i - 1] * a[i - 1];
            }
            int tmp = 1;
            // 计算 B[i] 的 上三角 各元素的乘积，记为 tmp ，并乘入 B[i]
            for (int i = a.length - 2; i >= 0; i--) {
                tmp *= a[i + 1];
                b[i] *= tmp;
            }
            return b;
        }
    }

    class Solution1 {
        public int[] constructArr(int[] a) {
            if (a == null || a.length == 0) {
                return a;
            }
            int len = a.length;
            int[] left = new int[len];
            int[] right = new int[len];
            left[0] = right[len - 1] = 1;

            for (int i = 1; i < len; i++) {
                left[i] = left[i - 1] * a[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                right[i] = right[i + 1] * a[i + 1];
            }

            int[] ans = new int[len];
            for (int i = 0; i < len; i++) {
                ans[i] = left[i] * right[i];
            }
            return ans;
        }
    }
}
