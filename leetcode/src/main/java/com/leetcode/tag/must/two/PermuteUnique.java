package com.leetcode.tag.must.two;

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
            if (deque.size() == nums.length) {
                result.add(new ArrayList<>(deque));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                // 去重
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
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
