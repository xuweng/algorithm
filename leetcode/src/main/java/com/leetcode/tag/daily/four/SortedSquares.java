package com.leetcode.tag.daily.four;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 */
public class SortedSquares {
    class Solution {
        public int[] sortedSquares(int[] A) {
            if (A == null || A.length == 0) {
                return new int[0];
            }
            for (int i = A.length - 1; i >= 0; i--) {
                if (Math.abs(A[i]) < Math.abs(A[0])) {
                    int temp = A[0];
                    A[0] = A[i];
                    A[i] = temp;
                }
                A[i] = A[i] * A[i];
            }
            Arrays.sort(A);

            return A;
        }
    }
}
