package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 18. 四数之和
 */
public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(nums);
            back(nums, target, 0, stack, result);

            return result;
        }

        /**
         * 通过start去重.
         * <p>
         * used是排列用法.
         * <p>
         * 排序去重.
         *
         * @param nums
         * @param target
         * @param start
         * @param stack
         * @param result
         */
        private void back(int[] nums, int target, int start, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == 4 && target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            if (stack.size() > 4) {
                return;
            }
            for (int i = start; i < nums.length; i++) {
                if (i > 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                stack.push(nums[i]);
                back(nums, target - nums[i], i + 1, stack, result);
                stack.pop();
            }
        }
    }
}
