package com.leetcode.tag.must2.four;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * <p>
 * 枚举依赖 枚举依赖 枚举依赖
 * <p>
 * 可变参数 可变参数 可变参数
 */
public class LargestDivisibleSubset {
    class Solution {
        public List<Integer> largestDivisibleSubset(int[] nums) {
            Arrays.sort(nums);

            int m = nums.length;
            int[] dp = new int[m];
            int[] back = new int[m];

            int max = 1;
            int index = 0;

            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[i] % nums[j] == 0) {
                        if (dp[i] < dp[j] + 1) {
                            dp[i] = dp[j] + 1;
                            back[i] = j;
                        }
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
