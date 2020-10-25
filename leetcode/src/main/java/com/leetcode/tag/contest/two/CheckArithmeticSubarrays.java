package com.leetcode.tag.contest.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 5547. 等差子数组
 */
public class CheckArithmeticSubarrays {
    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> result = new ArrayList<>();
            for (int i = 0; i < l.length; i++) {
                result.add(check(get(nums, l[i], r[i]), l[i], r[i]));
            }
            return result;
        }

        public int[] get(int[] nums, int l, int r) {
            int[] result = new int[r - l + 1];
            int index = 0;
            for (int i = l; i <= r; i++) {
                result[index++] = nums[i];
            }
            return result;
        }

        public boolean check(int[] nums, int l, int r) {
            if (l >= r) {
                return false;
            }
            int cha = nums[l + 1] - nums[l];
            for (int i = l + 1; i <= r; i++) {
                if (nums[i] - nums[i - 1] != cha) {
                    return false;
                }
            }
            return true;
        }
    }
}
