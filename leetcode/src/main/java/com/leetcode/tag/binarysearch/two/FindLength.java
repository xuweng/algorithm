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
        public int findLength(int[] A, int[] B) {
            if (A == null || A.length == 0 || B == null || B.length == 0) {
                return 0;
            }
            int[][] dp = new int[A.length][B.length];
            dp[0][0] = A[0] == B[0] ? 1 : 0;
            for (int i = 1; i < A.length; i++) {
                for (int j = 1; j < B.length; j++) {
                    dp[i][j] = A[i] == B[j] ? dp[i - 1][j - 1] + 1 : 0;
                }
            }
            return dp[A.length - 1][B.length - 1];
        }
    }
}
