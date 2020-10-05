package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 18. 四数之和
 */
public class FourSum {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            boolean[] used = new boolean[nums.length];

            back(nums, target, used, stack, result);

            return result;
        }

        private void back(int[] nums, int target, boolean[] used, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == 4 && target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                back(nums, target - nums[i], used, stack, result);
                stack.pop();
                used[i] = false;
            }
        }
    }
}
