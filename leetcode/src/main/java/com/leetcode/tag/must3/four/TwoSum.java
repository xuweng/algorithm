package com.leetcode.tag.must3.four;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 57. 和为s的两个数字
 */
public class TwoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    return new int[]{nums[left], nums[right]};
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

            return nums;
        }
    }

    class Solution1 {
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
}
