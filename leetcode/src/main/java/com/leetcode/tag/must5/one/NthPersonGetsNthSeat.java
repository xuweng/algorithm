package com.leetcode.tag.must5.one;

/**
 * 1227. 飞机座位分配概率
 */
public class NthPersonGetsNthSeat {
    class Solution {
        public double nthPersonGetsNthSeat(int n) {
            return n == 1 ? 1.0 : 0.5;
        }
    }

    class Solution1 {
        /**
         * 当 n=1 时，f(n)=1。
         * <p>
         * 当 n=2 时，f(n)=0.5。
         * <p>
         * 当 n>2 时，第 1 位乘客有 1/n 的概率选择第 1 个座位，有 1/n 的概率选择第 n 个座位，有 (n−2)/n 的概率选择其他座位。
         *
         * @param n
         * @return
         */
        public double nthPersonGetsNthSeat(int n) {
            if (n <= 2) {
                return 1.0 / n;
            }
            double prob = 0.5;
            for (int i = 3; i <= n; i++) {
                prob = (1.0 + (i - 2) * prob) / i;
            }
            return prob;
        }
    }
}
