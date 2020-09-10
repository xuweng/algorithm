package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 * <p>
 * 排序去重错误(不能选择相同数据)
 * <p>
 * 顺序选择错误(数组的数据有重复)
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
                stack.push(candidates[i]);
                back(candidates, target - candidates[i], i + 1, result, stack);
                stack.pop();
            }
        }
    }
}
