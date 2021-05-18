package com.leetcode.tag.must4.two;

/**
 * 1664. 生成平衡数组的方案数
 * <p>
 * 三取小 上边 左边
 */
public class WaysToMakeFair {
    public int waysToMakeFair(int[] nums) {
        int[] dp = new int[nums.length + 1];
        // dp[i]表示(0,1,2...,i-1)的奇偶数之差(偶数和-奇数和)
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + ((i & 1) == 0 ? nums[i - 1] : -nums[i - 1]);
        }
        int rev = 0;
        for (int i = 1; i < dp.length; i++) {
            //当删除第 i 个元素后(下标 i-1)，此元素之前奇偶数之差为 dp[i-1](偶-奇)
            //此元素之后奇偶数之差为 dp[n]-dp[i](偶-奇)
            //由于删除 i 后，奇偶翻转，所以只需判断相等即可
            if (dp[i - 1] == dp[nums.length] - dp[i]) {
                ++rev;
            }
        }
        return rev;
    }
}
