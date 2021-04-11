package com.leetcode.tag.must.five;

import java.util.*;

/**
 * 47. 全排列 II
 */
public class PermuteUnique {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            if (nums == null || nums.length == 0) {
                return result;
            }
            // 排序去重
            Arrays.sort(nums);
            used = new boolean[nums.length];

            dfs(nums);

            return result;
        }

        private void dfs(int[] nums) {
            if (nums.length == deque.size()) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                deque.push(nums[i]);
                dfs(nums);
                used[i] = false;
                deque.pop();
            }
        }
    }
}
