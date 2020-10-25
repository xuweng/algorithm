package com.leetcode.tag.contest.one;

/**
 * 5185. 存在连续三个奇数的数组
 */
public class ThreeConsecutiveOdds {
    /**
     * 1 <= arr.length <= 1000
     */
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            if (arr == null || arr.length < 3) {
                return false;
            }

            for (int i = 0; i < arr.length - 2; i++) {
                int j = i + 1;
                int k = j + 1;
                if (j < arr.length - 1 && k < arr.length) {
                    if (arr[i] % 2 != 0 && arr[j] % 2 != 0 && arr[k] % 2 != 0) {
                        return true;
                    }
                }
            }

            return false;
        }
    }
}
