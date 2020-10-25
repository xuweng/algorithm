package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 5547. 等差子数组
 */
public class CheckArithmeticSubarrays {
    static class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> result = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                result.add(check(get(nums, l[i], r[i])));
            }
            return result;
        }

        public int[] get(int[] nums, int l, int r) {
            int[] result = new int[r - l + 1];
            int index = 0;
            for (int i = l; i <= r; i++) {
                result[index++] = nums[i];
            }
            Arrays.sort(result);
            return result;
        }

        public boolean check(int[] nums) {
            if (nums.length <= 1) {
                return false;
            }
            int cha = nums[1] - nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] - nums[i - 1] != cha) {
                    return false;
                }
            }
            return true;
        }
    }
}
