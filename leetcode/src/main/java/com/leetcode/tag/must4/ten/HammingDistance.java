package com.leetcode.tag.must4.ten;

/**
 * 461. 汉明距离
 */
public class HammingDistance {
    class Solution {
        public int hammingDistance(int x, int y) {
            int s = x ^ y, ret = 0;
            while (s != 0) {
                s &= s - 1;
                ret++;
            }
            return ret;
        }
    }

    class Solution1 {
        public int hammingDistance(int x, int y) {
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                distance += 1;
                // 原数字 number 的最右边等于 1 的比特会被移除。
                xor = xor & (xor - 1);
            }
            return distance;
        }
    }
}
