package com.leetcode.tag.backtracking.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 */
public class CombinationSum3 {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            back(k, n, 1);

            return result;
        }

        public void back(int k, int n, int start) {
            if (deque.size() == k) {
                if (n == 0) {
                    result.add(new ArrayList<>(deque));
                }
                return;
            }
            for (int i = start; i <= 9 && i <= n; i++) {
                deque.push(i);
                back(k, n - i, i + 1);
                deque.pop();
            }
        }
    }
}
