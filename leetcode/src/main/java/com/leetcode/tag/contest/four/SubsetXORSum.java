package com.leetcode.tag.contest.four;

import java.util.*;

/**
 * 5759. 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {
    class Solution {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public int subsetXORSum(int[] nums) {
            int sum = Arrays.stream(nums).sum();

            dfs(nums, 0);

            for (List<Integer> integers : list) {
                if (integers.size() < 2) {
                    continue;
                }
                int i = 0;
                for (Integer integer : integers) {
                    i = i ^ integer;
                }
                sum += i;
            }

            return sum;
        }

        private void dfs(int[] nums, int index) {
            list.add(new ArrayList<>(deque));
            for (int i = index; i < nums.length; i++) {
                deque.push(nums[i]);

                dfs(nums, i + 1);

                deque.pop();
            }
        }
    }
}
