package com.leetcode.tag.must7.three;

/**
 * 1137. 第 N 个泰波那契数
 */
public class Tribonacci {
    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            int p0 = 0;
            int p1 = 1;
            int p2 = 2;

            int p3 = 0;
            for (int i = 3; i <= n; i++) {
                p3 = p0 + p1 + p2;

                p0 = p1;
                p1 = p2;
                p2 = p3;
            }

            return p3;
        }
    }
}
