package com.leetcode.tag.backtracking.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 */
public class Combine {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> combine(int n, int k) {
            back(n, k, 1);

            return result;
        }

        private void back(int n, int k, int start) {
            if (deque.size() == k) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = start; i <= n; i++) {
                deque.push(i);
                back(n, k, i + 1);
                deque.pop();
            }
        }
    }
}
