package com.leetcode.tag.must5.two;

/**
 * 477. 汉明距离总和
 */
public class TotalHammingDistance {
    /**
     * 方法一：逐位统计
     */
    class Solution {
        public int totalHammingDistance(int[] nums) {
            int ans = 0, n = nums.length;
            for (int i = 0; i < 30; ++i) {
                int c = 0;
                for (int val : nums) {
                    c += (val >> i) & 1;
                }
                ans += c * (n - c);
            }
            return ans;
        }
    }
}
