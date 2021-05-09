package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 配匹 配匹 配匹 配匹
 * <p>
 * 数据范围 数据范围 数据范围 数据范围
 * <p>
 * 二分 二分 二分 二分 二分 二分 二分
 * <p>
 * 贪心 贪心 贪心 贪心
 */
public class HammingWeight {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while (n != 0) {
                count++;
                n = n & (n - 1);
            }

            return count;
        }
    }
}
