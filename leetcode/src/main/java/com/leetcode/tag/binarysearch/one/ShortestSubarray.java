package com.leetcode.tag.binarysearch.one;

/**
 * 862. 和至少为 K 的最短子数组
 * <p>
 * 买股票:交易次数不会改变
 * <p>
 * 卖股票:交易次数+1
 */
public class ShortestSubarray {
    class Solution {
        public int shortestSubarray(int[] A, int K) {
            if (A == null || A.length == 0) {
                return -1;
            }
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < A.length; i++) {
                int sum = A[i];
                if (sum >= K) {
                    result = Math.min(result, 1);
                    break;
                }
                for (int j = i + 1; j < A.length; j++) {
                    sum += A[j];
                    if (sum >= K) {
                        result = Math.min(result, j - i + 1);
                        break;
                    }
                }
            }
            return result == Integer.MAX_VALUE ? -1 : result;
        }
    }
}
