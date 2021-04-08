package com.leetcode.tag.must.one.eight;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 */
public class Subsets {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null) {
                return result;
            }

            dfs(nums, 0);

            return result;
        }

        private void dfs(int[] nums, int index) {
            result.add(new ArrayList<>(deque));
            for (int i = index; i < nums.length; i++) {
                deque.push(nums[i]);
                dfs(nums, i + 1);
                deque.pop();
            }
        }
    }
}
