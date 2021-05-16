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

        //i：表示来到第i个位置
        public void dfs(int[] nums, int i, int xorSum) {
            if (i == nums.length) {
                res += xorSum;
                return;
            }
            //当前位置要
            dfs(nums, i + 1, xorSum ^ nums[i]);
            //当前位置不要
            dfs(nums, i + 1, xorSum);
        }
    }
}
