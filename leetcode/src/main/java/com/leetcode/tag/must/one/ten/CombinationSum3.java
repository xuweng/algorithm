package com.leetcode.tag.must.one.ten;

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
            dfs(k, n, 1);

            return result;
        }

        private void dfs(int k, int n, int index) {
            if (deque.size() > k || n < 0) {
                return;
            }
            if (deque.size() == k && n == 0) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = index; i <= 9; i++) {
                deque.push(i);
                dfs(k, n - i, i + 1);
                deque.pop();
            }
        }
    }
}
