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
}
