package com.leetcode.tag.must7.three;

/**
 * 509. 斐波那契数
 */
public class Fib {
    class Solution {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }

            return fib(n - 1) + fib(n - 2);
        }
    }

    class Solution1 {
        public int fib(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }

            int p1 = 0;
            int p2 = 1;
            int p3 = 1;
            for (int i = 2; i <= n; i++) {
                p3 = p1 + p2;

                p1 = p2;
                p2 = p3;
            }

            return p3;
        }
    }
}
