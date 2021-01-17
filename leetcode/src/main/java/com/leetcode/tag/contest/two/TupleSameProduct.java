package com.leetcode.tag.contest.two;

import java.util.Arrays;

/**
 * 5243. 同积元组
 */
public class TupleSameProduct {
    class Solution {
        public int tupleSameProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int k = i + 3; k < nums.length; k++) {
                    int p = nums[i] * nums[k];
                    int end = k - 1;
                    int j = i + 1;
                    while (j < end) {
                        int p1 = nums[j] * nums[end];
                        if (p == p1) {
                            result++;
                        }
                        j++;
                        end--;
                    }
                }
            }

            return result * 8;
        }
    }

    class Solution1 {
        public int tupleSameProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            Arrays.sort(nums);
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        for (int l = k + 1; l < nums.length; l++) {
                            if (nums[i] * nums[l] == nums[j] * nums[k] || nums[i] * nums[k] == nums[j] * nums[l]) {
                                result++;
                            }
                        }
                    }
                }
            }

            return result * 8;
        }
    }
}
