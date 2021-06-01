package com.leetcode.tag.must5.seven;

/**
 * 1340. 跳跃游戏 V
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * 区间dp 区间dp 区间dp
 * <p>
 * [i,j] [i,k] [k,j]
 */
public class MaxJumps {
    class Solution {
        private int[] arr;
        private int[] f;
        private int d;

        public int maxJumps(int[] arr, int d) {
            this.f = new int[arr.length];
            this.d = d;
            this.arr = arr;
            int max = 0;

            for (int i = 0; i < arr.length; i++) {
                max = Math.max(max, dp(i));
            }
            return max;
        }

        public int dp(int dis) {
            if (f[dis] != 0) {
                return f[dis];
            }
            //初始值
            f[dis] = 1;
            //向右跳
            for (int i = dis + 1; i < arr.length && i <= dis + d; i++) {
                if (arr[i] >= arr[dis]) {
                    break;
                }
                f[dis] = Math.max(dp(i) + 1, f[dis]);
            }
            //向左跳
            for (int i = dis - 1; i >= 0 && i >= dis - d; i--) {
                if (arr[i] >= arr[dis]) {
                    break;
                }
                f[dis] = Math.max(dp(i) + 1, f[dis]);
            }
            return f[dis];
        }
    }

    class Solution1 {
        int[] arr;
        int n; //数组长度
        int d;
        int[] dp;   //用来存储每个柱子的最大结果

        public int maxJumps(int[] arr, int d) {
            this.arr = arr;
            this.n = arr.length;
            this.d = d;
            dp = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, getMaxFromOnePoint(i));
            }
            return ans;
        }

        private int getMaxFromOnePoint(int p) {
            if (dp[p] != 0) return dp[p];   //当前柱子已经计算过，直接返回它的值
            // 如果没有，分别计算它往左和往右跳一次可以得到的最大值
            int leftMax = 0;
            int l = 1;  // 往左跳的距离
            while (p - l >= 0 && l <= d) {
                if (arr[p - l] >= arr[p]) {   //遇到了高柱子挡路，只能结束
                    break;
                } else {
                    if (dp[p - l] == 0) dp[p - l] = getMaxFromOnePoint(p - l);
                    leftMax = Math.max(leftMax, dp[p - l]);
                    l++;
                }
            }
            // 同理右边
            int rightMax = 0;
            int r = 1;
            while (p + r < n && r <= d) {
                if (arr[p + r] >= arr[p]) {
                    break;
                } else {
                    if (dp[p + r] == 0) dp[p + r] = getMaxFromOnePoint(p + r);
                    rightMax = Math.max(rightMax, dp[p + r]);
                    r++;
                }
            }
            dp[p] = Math.max(leftMax, rightMax) + 1;
            return dp[p];
        }
    }
}
