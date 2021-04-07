package com.leetcode.tag.must.ten;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 */
public class Permute {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            if (nums == null || nums.length == 0) {
                return result;
            }
            used = new boolean[nums.length];

            dfs(nums);

            return result;
        }

        private void dfs(int[] nums) {
            if (deque.size() == nums.length) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                deque.push(nums[i]);
                dfs(nums);
                deque.pop();
                used[i] = false;
            }
        }
    }
}
