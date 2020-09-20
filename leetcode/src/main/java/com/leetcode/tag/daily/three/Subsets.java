package com.leetcode.tag.daily.three;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(nums, 0, result, stack);

            return result;
        }

        private void back(int[] nums, int begin, List<List<Integer>> result, Deque<Integer> stack) {
            result.add(new ArrayList<>(stack));

            for (int i = begin; i < nums.length; i++) {
                stack.push(nums[i]);
                back(nums, i + 1, result, stack);
                stack.pop();
            }
        }
    }
}
