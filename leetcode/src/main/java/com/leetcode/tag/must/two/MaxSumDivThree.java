package com.leetcode.tag.must.two;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 1262. 可被三整除的最大和
 */
public class MaxSumDivThree {
    class Solution {
        public int maxSumDivThree(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[][] dp = new int[nums.length + 1][3];
            dp[0][1] = Integer.MIN_VALUE;
            dp[0][2] = Integer.MIN_VALUE;

            for (int i = 1; i <= nums.length; i++) {
                if (nums[i - 1] % 3 == 0) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][0] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][1] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][2] + nums[i - 1]);
                } else if (nums[i - 1] % 3 == 1) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + nums[i - 1]);
                } else if (nums[i - 1] % 3 == 2) {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + nums[i - 1]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] + nums[i - 1]);
                    dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][0] + nums[i - 1]);
                }
            }

            return dp[nums.length][0];
        }
    }

    class Solution1 {
        List<List<Integer>> list = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        public int maxSumDivThree(int[] nums) {
            back(nums, 0);

            int max = 0;
            for (List<Integer> integers : list) {
                int sum = integers.stream().mapToInt(Integer::intValue).sum();

                if (sum % 3 == 0) {
                    max = Math.max(max, sum);
                }
            }

            return max;
        }

        private void back(int[] nums, int start) {
            list.add(new ArrayList<>(deque));

            for (int i = start; i < nums.length; i++) {
                deque.push(nums[i]);
                back(nums, i + 1);
                deque.pop();
            }
        }
    }
}
