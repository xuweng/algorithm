package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            Deque<Integer> stack = new LinkedList<>();

            back(k, n, 0, result, stack);

            return result;
        }

        private void back(int k, int n, int begin, List<List<Integer>> result, Deque<Integer> stack) {
            if (n < 0) {
                return;
            }
            if (n == 0 && stack.size() == k) {
                result.add(new ArrayList<>(stack));
                return;
            }

            for (int i = begin; i <= 9; i++) {
                if (n - i < 0) {
                    break;
                }
                stack.push(i);
                back(k, n - i, i + 1, result, stack);
                stack.pop();
            }
        }
    }
}
