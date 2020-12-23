package com.leetcode.tag.backtracking.two;

import java.util.*;

/**
 * 39. 组合总和
 */
public class CombinationSum {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);

            back(candidates, target, 0);

            return result;
        }

        private void back(int[] candidates, int target, int start) {
            if (target == 0) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                deque.push(candidates[i]);
                back(candidates, target - candidates[i], i);
                deque.pop();
            }
        }
    }
}
