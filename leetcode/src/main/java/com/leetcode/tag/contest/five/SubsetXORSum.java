package com.leetcode.tag.contest.five;

/**
 * 5759. 找出所有子集的异或总和再求和
 */
public class SubsetXORSum {
    class Solution {
        int res = 0;

        public int subsetXORSum(int[] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            dfs(nums, 0, 0);

            return res;
        }

        /**
         * index：表示来到第index个位置
         *
         * @param nums
         * @param index
         * @param xorSum
         */
        public void dfs(int[] nums, int index, int xorSum) {
            if (index == nums.length) {
                res += xorSum;
                return;
            }
            // 选择index
            dfs(nums, index + 1, xorSum ^ nums[index]);
            // 不选择index
            dfs(nums, index + 1, xorSum);
        }
    }
}
