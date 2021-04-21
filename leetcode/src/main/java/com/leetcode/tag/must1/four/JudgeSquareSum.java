package com.leetcode.tag.must1.four;

/**
 * 633. 平方数之和
 */
public class JudgeSquareSum {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0;
            int right = (int) Math.sqrt(c);

            while (left <= right) {
                int sum = left * left + right * right;
                if (sum == c) {
                    return true;
                }
                if (sum < c) {
                    left++;
                } else {
                    right--;
                }
            }

            return false;
        }
    }
}
