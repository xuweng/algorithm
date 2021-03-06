package com.leetcode.tag.backtracking.two;

/**
 * 650. 只有两个键的键盘
 */
public class MinSteps {
    class Solution {
        public int minSteps(int n) {
            return dfs(n, 1, 0, true);
        }

        private int dfs(int n, int num, int paste, boolean copy) {
            if (num > n) {
                return 10000;
            }
            if (n == num) {
                return 0;
            }
            if (copy) {
                return dfs(n, num, num, false) + 1;
            }
            int i = dfs(n, num + paste, paste, true);
            int j = dfs(n, num + paste, paste, false);

            return Math.min(i, j) + 1;
        }
    }
}
