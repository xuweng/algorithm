package com.leetcode.tag.dp.one.three;

import java.util.Arrays;

/**
 * 1191. K 次串联后最大子数组之和
 */
public class KConcatenationMaxSum {
    class Solution {
        public int kConcatenationMaxSum(int[] arr, int k) {
            if (arr == null || arr.length == 0) {
                return 0;
            }
            int result = 0;
            int max = 0;
            int index = Math.min(2, k) * arr.length;
            for (int i = 0; i < index; i++) {
                int val = arr[i % arr.length];

                max = Math.max(max + val, val);
                result = Math.max(result, max);
            }
            int sum = Arrays.stream(arr).sum();
            while (k > 2 && sum > 0) {
                result = (result + sum) % 1000000007;
                k--;
            }

            return result;
        }
    }
}
