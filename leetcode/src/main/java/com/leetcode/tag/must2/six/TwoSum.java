package com.leetcode.tag.must2.six;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(target - num)) {
                    return new int[]{num, target - num};
                } else {
                    set.add(num);
                }
            }

            return nums;
        }
    }

    /**
     * 双指针
     */
    class Solution1 {
        public int[] twoSum(int[] nums, int target) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{nums[i], nums[j]};
                }
                if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
            return new int[0];
        }
    }
}
