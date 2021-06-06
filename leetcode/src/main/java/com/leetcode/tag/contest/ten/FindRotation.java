package com.leetcode.tag.contest.ten;

/**
 * 5776. 判断矩阵经轮转后是否一致
 */
public class FindRotation {
    class Solution {
        public boolean findRotation(int[][] mat, int[][] target) {
            int m = mat.length;
            int i = 0;
            int j = m - 1;
            if (m == 1) {
                return mat[0][0] == target[0][0];
            }

            while (i < j) {
                for (int k = 0; k < m; k++) {
                    if (mat[i][k] == mat[j][k]) {
                        return false;
                    }
                }
                i++;
                j--;
            }

            return true;
        }
    }
}
