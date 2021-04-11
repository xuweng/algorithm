package com.leetcode.tag.must.five;

import java.util.*;

/**
 * 90. 子集 II
 */
public class SubsetsWithDup {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums == null || nums.length == 0) {
                return result;
            }
            // 排序去重
            Arrays.sort(nums);

            dfs(nums, 0);

            return result;
        }

        private void dfs(int[] nums, int index) {
            result.add(new ArrayList<>(deque));
            for (int i = index; i < nums.length; i++) {
                if (i > index && nums[i - 1] == nums[i]) {
                    continue;
                }
                deque.push(nums[i]);
                dfs(nums, i + 1);
                deque.pop();
            }
        }
    }
}
