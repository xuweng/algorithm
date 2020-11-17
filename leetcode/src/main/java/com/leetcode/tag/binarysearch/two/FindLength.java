package com.leetcode.tag.binarysearch.two;

/**
 * 718. 最长重复子数组
 * <p>
 * 桶排序。桶排序。桶排序。桶排序。桶排序。桶排序。桶排序
 * <p>
 * 连续。不连续。连续。不连续。连续。不连续。
 * <p>
 * 桶排序。桶排序。桶排序。桶排序。桶排序。桶排序。桶排序。桶排序
 * <p>
 * 连续。不连续。连续。不连续。连续。不连续。
 */
public class FindLength {
    class Solution {
        /**
         * 脑里跑一下代码
         * <p>
         * 注意数组越界
         * <p>
         * 注意初始化
         *
         * @param A
         * @param B
         * @return
         */
        public int findLength(int[] A, int[] B) {
            if (A == null || A.length == 0 || B == null || B.length == 0) {
                return 0;
            }
            int[][] dp = new int[A.length][B.length];
            int result = 0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = A[i] == B[j] ? 1 : 0;
                    } else {
                        dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                    }
                    result = Math.max(result, dp[i][j]);
                }
            }
            return result;
        }
    }
}
