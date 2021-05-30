package com.leetcode.tag.must5.four;

/**
 * 191. 位1的个数
 */
public class HammingWeight {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int result = 0;
            while (n != 0) {
                result++;
                n = n & (n - 1);
            }

            return result;
        }
    }
}
