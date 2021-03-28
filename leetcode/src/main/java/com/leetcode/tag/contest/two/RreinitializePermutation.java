package com.leetcode.tag.contest.two;

/**
 * 5715. 还原排列的最少操作步数
 */
public class RreinitializePermutation {
    class Solution {
        public int reinitializePermutation(int n) {
            if (n == 2) {
                return 1;
            }
            return n - 2;
        }
    }
}
