package com.leetcode.tag.must3.ten;

import java.util.Arrays;

/**
 * 410. 分割数组的最大值
 * <p>
 * 长度划分 前k-1 第k
 * <p>
 * dp[i] dp[j] [j,i-1]
 * <p>
 * dp[i][k] dp[j][k-1] [j,i-1]
 */
public class SplitArray {
    class Solution {
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            // 令 dp[i][j]表示将数组的前 i 个数分割为 j 段所能得到的最大连续子数组和的最小值
            int[][] dp = new int[n + 1][m + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            dp[0][0] = 0;
            // 前缀和
            int[] preSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            // 枚举长度
            for (int i = 1; i <= n; i++) {
                // 枚举下标
                for (int j = 0; j < i; j++) {
                    // 枚举k
                    // i个数 划分m部分
                    for (int k = 1; k <= Math.min(i, m); k++) {
                        // 前k-1个 第k个 最后一个
                        // 第k个 [j,i-1] 区间和 preSum[i] - preSum[j]
                        dp[i][k] = Math.min(dp[i][k], Math.max(dp[j][k - 1], preSum[i] - preSum[j]));
                    }
                }
            }
            return dp[n][m];
        }
    }

    /**
     * 「将数组分割为 m 段，求……」是动态规划题目常见的问法。
     * <p>
     * 方法二：二分查找 + 贪心
     * <p>
     * 类似船的运输
     * <p>
     * 「使……最大值尽可能小」是二分搜索题目常见的问法。
     */
    class Solution1 {
        public int splitArray(int[] nums, int m) {
            int left = Arrays.stream(nums).max().getAsInt();
            int right = Arrays.stream(nums).sum();

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (check(nums, mid, m)) {
                    // 满足条件 缩小区间
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // left=right
            return left;
        }

        public boolean check(int[] nums, int x, int m) {
            int sum = 0;
            // 第一个
            int cnt = 1;
            for (int num : nums) {
                sum += num;
                if (sum > x) {
                    // 下一个
                    cnt++;
                    sum = num;
                }
            }
            return cnt <= m;
        }
    }

    class Solution2 {
        public int splitArray(int[] nums, int m) {
            int left = Arrays.stream(nums).max().getAsInt();
            int right = Arrays.stream(nums).sum();

            while (left < right) {
                int mid = left + (right - left) / 2;
                int sum = 0;
                // 第一个
                int cnt = 1;
                for (int num : nums) {
                    sum += num;
                    if (sum > mid) {
                        // 下一个
                        cnt++;
                        sum = num;
                    }
                }
                if (cnt <= m) {
                    // 满足条件 缩小区间
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // left=right
            return left;
        }
    }
}
