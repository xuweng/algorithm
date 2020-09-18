package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);

            boolean[] used = new boolean[nums.length];
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            back(nums, used, stack, result);

            return result;
        }

        private void back(int[] nums, boolean[] used, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //没有去重
                if ((used[i])) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                back(nums, used, stack, result);
                used[i] = false;
                stack.pop();
            }
        }
    }
}
