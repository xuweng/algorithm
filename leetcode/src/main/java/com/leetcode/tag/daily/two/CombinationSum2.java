package com.leetcode.tag.daily.two;

import java.util.*;

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
                if (i > 0 && candidates[i] == candidates[i - 1] && stack.isEmpty()) {
                    continue;
                }
                stack.push(candidates[i]);
                back(candidates, target - candidates[i], i + 1, result, stack);
                stack.pop();
            }
        }
    }

    /**
     * 厉害
     */
    class Solution1 {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);

            List<Integer> path = new ArrayList<>();

            backtrack(path, candidates, target, 0, 0);

            return res;
        }

        private void backtrack(List<Integer> path, int[] candidates, int target, int sum, int begin) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = begin; i < candidates.length; i++) {
                if (i > begin && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                int rs = candidates[i] + sum;
                if (rs > target) {
                    //数组已经排序,可以在这里剪枝,后面的数据都不用看了
                    break;
                } else {
                    path.add(candidates[i]);
                    backtrack(path, candidates, target, rs, i + 1);
                    path.remove(path.size() - 1);
                }
            }
        }

    }
}
