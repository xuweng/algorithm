package com.leetcode.tag.must1.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 368. 最大整除子集
 */
public class LargestDivisibleSubset {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            int[] dp = new int[nums.length];
            int[] back = new int[nums.length];

            int max = 1;
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        back[i] = j;
                    }
                }

                if (max < dp[i]) {
                    max = dp[i];
                    index = i;
                }
            }

            List<Integer> result = new ArrayList<>();
            while (result.size() != max) {
                result.add(nums[index]);
                index = back[index];
            }

            return result;
        }
    }
}
