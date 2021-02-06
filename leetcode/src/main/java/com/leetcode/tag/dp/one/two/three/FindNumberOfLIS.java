package com.leetcode.tag.dp.one.two.three;

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
            //最长递增子序列(LIS):Longest Increasing Subsequence(LIS):LongestIncreasingSubsequence
            // 以 nums[i] 结尾的序列
            // 我们知道最长序列的长度 length[i]
            // 以nums[i]结尾的LIS长度
            int[] lengths = new int[N]; //lengths[i] = length of longest ending in nums[i]
            // 以及具有该长度的序列的 count[i]
            // 以nums[i]结尾的LIS的组合的个数
            int[] counts = new int[N]; //count[i] = number of longest ending in nums[i]
            // 初始化为1.初始化为1.初始化为1.
            Arrays.fill(counts, 1);

            //若要LIS成立，我们只要考虑nums[i] < nums[j]的情况，其他情况则不考虑
            for (int j = 0; j < N; ++j) {
                for (int i = 0; i < j; ++i) {
                    if (nums[i] < nums[j]) {
                        // 多了一个判断
                        // 第一次找到某个长度
                        if (lengths[i] >= lengths[j]) {
                            // 更新j
                            lengths[j] = lengths[i] + 1;
                            counts[j] = counts[i];
                        } else if (lengths[i] + 1 == lengths[j]) {
                            // 再次找到某个长度
                            counts[j] += counts[i];
                        }
                    }
                }
            }

            int longest = 0;
            for (int length : lengths) {
                longest = Math.max(longest, length);
            }
            int ans = 0;
            for (int i = 0; i < N; ++i) {
                if (lengths[i] == longest) {
                    ans += counts[i];
                }
            }
            return ans;
        }
    }

    /**
     * 写一遍 跑一遍 跑一遍
     */
    class Solution2 {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] length = new int[nums.length];
            Arrays.fill(length, 1);
            int[] count = new int[nums.length];
            Arrays.fill(count, 1);
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (length[j] >= length[i]) {
                            length[i] = length[j] + 1;
                            count[i] = count[j];
                        } else if (length[j] + 1 == length[i]) {
                            count[i] += count[j];
                        }
                    }
                }
                max = Math.max(max, length[i]);
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (length[i] == max) {
                    result += count[i];
                }
            }
            return result;
        }
    }

    /**
     * 举例子 举例子 举例子 举例子 举例子 举例子
     */
    class Solution3 {
        public int findNumberOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int[] lengths = new int[nums.length];
            int[] counts = new int[nums.length];
            Arrays.fill(lengths, 1);
            Arrays.fill(counts, 1);
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        if (lengths[j] >= lengths[i]) {
                            lengths[i] = lengths[j] + 1;
                            counts[i] = counts[j];
                        } else if (lengths[j] + 1 == lengths[i]) {
                            counts[i] += counts[j];
                        }
                    }
                }
                max = Math.max(max, lengths[i]);
            }
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (lengths[i] == max) {
                    result += counts[i];
                }
            }
            return result;
        }
    }

}
