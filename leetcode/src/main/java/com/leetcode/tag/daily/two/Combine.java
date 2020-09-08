package com.leetcode.tag.daily.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            Deque<Integer> stack = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();

            back(n, 1, k, stack, result);

            return result;
        }

        private void back(int n, int start, int k, Deque<Integer> stack, List<List<Integer>> result) {
            if (stack.size() == k) {
                result.add(new ArrayList<>(stack));
                return;
            }
            for (int i = start; i <= n; i++) {
                stack.push(i);
                back(n, i + 1, k, stack, result);
                stack.pop();
            }
        }
    }
}
