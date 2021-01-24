package com.leetcode.tag.contest.two;

import java.util.*;

/**
 * 5663. 找出第 K 大的异或坐标值
 */
public class KthLargestValue {
    class Solution {
        int[][] meno;

        public int kthLargestValue(int[][] matrix, int k) {
            meno = new int[matrix.length][matrix[0].length];
            for (int[] ints : meno) {
                Arrays.fill(ints, -1);
            }

            List<Integer> list = new ArrayList<>();
            list.add(matrix[0][0]);
            meno[0][0] = matrix[0][0];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int zheng = zheng(matrix, i, j);
                    list.add(zheng);
                }
            }
            list.sort(Collections.reverseOrder());

            return list.get(k - 1);
        }

        private int zheng(int[][] matrix, int row, int col) {
            if (row == 0) {
                meno[row][col] = meno[row][col - 1] ^ matrix[row][col];
            } else if (col == 0) {
                meno[row][col] = meno[row - 1][col] ^ matrix[row][col];
            } else {
                int pre = meno[row - 1][col];
                for (int i = 0; i <= col; i++) {
                    pre = pre ^ matrix[row][i];
                }
                meno[row][col] = pre;
            }

            return meno[row][col];
        }
    }

    /**
     * dp方程错误
     * <p>
     * dp+优先队列
     * <p>
     * 作者：rational-irrationality
     * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/java-dong-tai-gui-hua-you-xian-dui-lie-b-2acz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    static class Solution1 {
        public int kthLargestValue(int[][] matrix, int k) {
            int row = matrix.length;
            int col = matrix[0].length;
            int[][] dp = new int[row][col];
            dp[0][0] = matrix[0][0];

            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> (b - a));
            priorityQueue.offer(matrix[0][0]);
            for (int i = 1; i < col; i++) {
                dp[0][i] = dp[0][i - 1] ^ matrix[0][i];
                priorityQueue.offer(dp[0][i]);
            }
            for (int i = 1; i < row; i++) {
                dp[i][0] = dp[i - 1][0] ^ matrix[i][0];
                priorityQueue.offer(dp[i][0]);
            }
            for (int i = 1; i < row; i++) {
                for (int j = 1; j < col; j++) {
                    dp[i][j] = dp[i - 1][j] ^ dp[i][j - 1] ^ matrix[i][j];
                    priorityQueue.offer(dp[i][j]);
                }
            }
            while (k > 1) {
                priorityQueue.poll();
                k--;
            }
            return priorityQueue.poll();

        }
    }

    /**
     * Java 动态规划，优先队列
     * <p>
     * 作者：rational-irrationality
     * 链接：https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/solution/java-dong-tai-gui-hua-you-xian-dui-lie-b-2acz/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public int kthLargestValue(int[][] ma, int k) {
            int n = ma.length;
            int m = ma[0].length;
            int[][] dp = new int[n + 1][m + 1];
            PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> (b - a));
            //从i=1;j=1开始遍历,省去判断边界问题
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    // 这3个状态真是厉害
                    dp[i][j] = dp[i - 1][j - 1] ^ dp[i - 1][j] ^ dp[i][j - 1] ^ ma[i - 1][j - 1];
                    p.offer(dp[i][j]);
                }
            }
            while (k > 1) {
                p.poll();
                k--;
            }
            return p.poll();

        }
    }

}
