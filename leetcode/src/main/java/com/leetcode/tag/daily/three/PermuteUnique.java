package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 47. 全排列 II
 * <p>
 * 几乎每次去重都错
 */
public class PermuteUnique {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);

            boolean[] used = new boolean[nums.length];
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            back(nums, used, 0, stack, result);

            return result;
        }

        /**
         * 脑里执行一遍示例
         * <p>
         * begin是递归层次.递归层次.递归层次
         *
         * @param nums
         * @param used
         * @param begin
         * @param stack
         * @param result
         */
        private void back(int[] nums, boolean[] used, int begin, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == nums.length) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                //没有去重
                if ((used[i]) || (i > begin && nums[i] == nums[i - 1])) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                back(nums, used, begin + 1, stack, result);
                used[i] = false;
                stack.pop();
            }
        }
    }
}
