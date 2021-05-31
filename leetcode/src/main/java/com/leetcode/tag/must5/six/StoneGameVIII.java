package com.leetcode.tag.must5.six;

/**
 * 1872. 石子游戏 VIII
 */
public class StoneGameVIII {
    class Solution {
        public int stoneGameVIII(int[] stones) {
            int n = stones.length;
            for (int i = 1; i < n; i++) {
                stones[i] += stones[i - 1];
            }
            int max = stones[n - 1];
            for (int i = n - 2; i > 0; i--) {
                max = Math.max(max, stones[i] - max);
            }
            return max;
        }
    }

    class Solution1 {
        int n;
        int[] stones;
        int[] sum;

        public int stoneGameVIII(int[] stones) {
            n = stones.length;
            this.stones = stones;
            sum = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stones[i];
            }

            return solve(2);
        }

        public int solve(int idx) {
            if (idx == n) {
                return sum[idx];
            }

            int res = sum[n];
            for (int i = idx; i < n; i++) {
                res = Math.max(res, sum[i] - solve(i + 1));
            }
            return res;
        }
    }

    class Solution2 {
        int n;
        int[] stones;
        int[] sum;
        Integer[] memo;

        public int stoneGameVIII(int[] stones) {
            n = stones.length;
            this.stones = stones;

            memo = new Integer[n + 1];
            sum = new int[n + 1];

            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stones[i];
            }
            memo[n] = sum[n];

            return solve(2);
        }

        public int solve(int idx) {
            if (memo[idx] != null) {
                return memo[idx];
            }

            int res = sum[n];
            for (int i = idx; i < n; i++) {
                res = Math.max(res, sum[i] - solve(i + 1));
            }
            memo[idx] = res;
            return res;
        }
    }
}
