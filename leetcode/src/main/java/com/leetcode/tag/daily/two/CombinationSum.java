package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(candidates, target, 0, result, stack);

            return result;
        }

        /**
         * 数据重复
         * <p>
         * 解集不能包含重复的组合
         *
         * @param candidates
         * @param target
         * @param sum
         * @param result
         * @param stack
         */
        private void back(int[] candidates, int target, int sum, List<List<Integer>> result, Deque<Integer> stack) {
            if (sum == target) {
                result.add(new ArrayList<>(stack));
                return;
            }
            if (sum > target) {
                return;
            }
            for (int candidate : candidates) {
                stack.push(candidate);
                back(candidates, target, sum + candidate, result, stack);
                stack.pop();
            }
        }
    }
}
