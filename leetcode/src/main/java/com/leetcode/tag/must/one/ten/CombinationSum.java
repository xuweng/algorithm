package com.leetcode.tag.must.one.ten;

import java.util.*;

/**
 * 39. 组合总和
 */
public class CombinationSum {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates == null || candidates.length == 0) {
                return result;
            }
            // 剪枝
            Arrays.sort(candidates);

            dfs(candidates, 0, 0, target);

            return result;
        }

        private void dfs(int[] candidates, int index, int sum, int target) {
            if (sum == target) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
                deque.push(candidates[i]);
                dfs(candidates, i, sum + candidates[i], target);
                deque.pop();
            }
        }
    }
}
