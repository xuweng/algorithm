package com.leetcode.tag.daily.two;

import java.util.*;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    /**
     * candidates 中的每个数字在每个组合中只能使用一次
     * <p>
     * 解集不能包含重复的组合。
     */
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            Arrays.sort(candidates);

            back(candidates, target, 0, result, stack);

            return result;
        }

        private void back(int[] candidates, int target, int begin, List<List<Integer>> result, Deque<Integer> stack) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                //排序去重错误
                if (i > 0 && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                stack.push(candidates[i]);
                back(candidates, target - candidates[i], i + 1, result, stack);
                stack.pop();
            }
        }
    }
}
