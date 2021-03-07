package com.leetcode.tag.dp.one.three;

/**
 * 1504. 统计全 1 子矩形
 */
public class NumSubmat {
    /**
     * 从左到右统计1
     * <p>
     * 方法一：枚举
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/count-submatrices-with-all-ones/solution/tong-ji-quan-1-zi-ju-xing-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        public int numSubmat(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;
            // 预处理 row 数组，其中 row[i][j] 代表矩阵中 (i,j) 向左延伸连续 1 的个数
            int[][] row = new int[n][m];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    if (j == 0) {
                        row[i][j] = mat[i][j];
                    } else if (mat[i][j] != 0) {
                        row[i][j] = row[i][j - 1] + 1;
                    } else {
                        row[i][j] = 0;
                    }
                }
            }
            int ans = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    // 枚举子矩形的高 枚举行
                    int col = row[i][j];
                    for (int k = i; k >= 0 && col != 0; --k) {
                        col = Math.min(col, row[k][j]);
                        ans += col;
                    }
                }
            }
            return ans;
        }
    }

    /**
     * 从上到下统计1
     */
    class Solution1 {
        public int numSubmat(int[][] mat) {
            int row = mat.length;
            int col = mat[0].length;

            int res = 0;
            //定义dp[i][j] 为第i行，从0~j的全部为1的个数
            int[][] dp = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (mat[i][j] == 0) {
                        continue;
                    }

                    dp[i][j] = j == 0 ? 1 : dp[i][j - 1] + 1;
                    int min = dp[i][j];
                    for (int k = i; k >= 0 && mat[i][j] != 0; k--) {
                        //依次往上找，与上一行的矩形个数为与上一行dp[i][j]的最小值
                        min = Math.min(min, dp[k][j]);
                        res += min;
                    }
                }
            }

            return res;
        }
    }

}
