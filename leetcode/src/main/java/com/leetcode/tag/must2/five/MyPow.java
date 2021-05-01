package com.leetcode.tag.must2.five;

/**
 * 50. Pow(x, n)
 */
public class MyPow {
    class Solution {
        public double myPow(double x, int n) {
            long N = n;

            return n >= 0 ? pow(x, N) : 1.0 / pow(x, -N);
        }

        private double pow(double x, long n) {
            if (x == 1 || n == 0) {
                return 1.0;
            }
            if (n == 1) {
                return x;
            }
            double mid = pow(x, n / 2);

            return n % 2 == 0 ? mid * mid : mid * mid * x;
        }
    }
}
