package com.leetcode.tag.dp.three;

import java.util.Arrays;

/**
 * 673. 最长递增子序列的个数
 * <p>
 * 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目
 * <p>
 * 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂题目 搞懂美团
 * <p>
 * 路径个数 路径个数 路径个数 路径个数 路径个数 路径个数
 * <p>
 * 回溯 回溯 回溯 回溯 回溯 路径个数 路径个数 路径个数
 * <p>
 * 十分钟看答案 十分钟看答案 十分钟看答案 十分钟看答案
 * <p>
 * 十分钟看答案 十分钟看答案 十分钟看答案 十分钟看答案
 * <p>
 * 最长递增子序列(LIS):Longest Increasing Subsequence(LIS):LongestIncreasingSubsequence
 */
public class FindNumberOfLIS {
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] dp = new int[nums.length];
            dp[0] = 1;
            int max = 1;
            int result = 1;
            for (int i = 1; i < nums.length; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (dp[j] < dp[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                // 错误
                if (dp[i] == max) {
                    result++;
                } else if (dp[i] > max) {
                    result = 1;
                    max = dp[i];
                }
            }

            return result;

        }
    }

    /**
     * 方法一：动态规划
     * <p>
     * 大脑里跑一遍 大脑跑一遍 大脑跑一遍
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int findNumberOfLIS(int[] nums) {
            int N = nums.length;
            if (N <= 1) {
                return N;
            }
            // 以 nums[i] 结尾的序列
            // 我们知道最长序列的长度 length[i]
            int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
            // 以及具有该长度的序列的 count[i]
            int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
            // 初始化为1.初始化为1.初始化为1.
            Arrays.fill(counts, 1);

            for (int j = 0; j < N; ++j) {
                for (int i = 0; i < j; ++i) {
                    if (nums[i] < nums[j]) {
                        // 多了一个判断
                        if (lengths[i] >= lengths[j]) {
                            // 更新j
                            lengths[j] = lengths[i] + 1;
                            counts[j] = counts[i];
                        } else if (lengths[i] + 1 == lengths[j]) {
                            counts[j] += counts[i];
                        }
                    }
                }
            }

            int longest = 0, ans = 0;
            for (int length : lengths) {
                longest = Math.max(longest, length);
            }
            for (int i = 0; i < N; ++i) {
                if (lengths[i] == longest) {
                    ans += counts[i];
                }
            }
            return ans;
        }
    }

}
