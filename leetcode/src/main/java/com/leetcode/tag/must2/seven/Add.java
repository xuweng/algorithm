package com.leetcode.tag.must2.seven;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 */
public class Add {
    class Solution {
        public int add(int a, int b) {
            return a + b;
        }
    }

    /**
     * 本题考察对位运算的灵活使用，即使用位运算实现加法
     */
    class Solution1 {
        public int add(int a, int b) {
            while (b != 0) { // 当进位为 0 时跳出
                int c = (a & b) << 1;  // c = 进位
                a ^= b; // a = 非进位和
                b = c; // b = 进位
            }
            return a;
        }
    }
}
