package com.leetcode.tag.must.eight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 * <p>
 * 下标 长度
 * <p>
 * 已经计算前一部分 dp[0,j] 只需要判断[j+1,i]
 */
public class MinimumEffortPath {
    class Solution {
        int row;
        int col;

        public int minimumEffortPath(int[][] heights) {
            if (heights == null) {
                return 0;
            }
            row = heights.length;
            col = heights[0].length;

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // 下一行
                    if (i + 1 < row) {
                        int a = getIndex(i, j);
                        int b = getIndex(i + 1, j);
                        int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                        list.add(new int[]{a, b, w});
                    }
                    // 下一列
                    if (j + 1 < col) {
                        int a = getIndex(i, j);
                        int b = getIndex(i, j + 1);
                        int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                        list.add(new int[]{a, b, w});
                    }
                }
            }
            // 按照w升序
            list.sort(Comparator.comparingInt(a -> a[2]));
            int start = getIndex(0, 0);
            int end = getIndex(row - 1, col - 1);

            UF uf = new UF(row * col);
            for (int[] ints : list) {
                int a = ints[0], b = ints[1], w = ints[2];
                uf.union(a, b);
                if (uf.isConnected(start, end)) {
                    return w;
                }
            }

            return 0;
        }

        /**
         * 下标获取数字
         *
         * @param i
         * @param j
         * @return
         */
        int getIndex(int i, int j) {
            return i * col + j;
        }

    }

    class UF {
        private int[] parent;
        int count;
        int size;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            count = n;
        }

        public boolean union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);

            if (iRoot == jRoot) {
                return false;
            }
            parent[iRoot] = jRoot;

            return true;
        }

        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }
    }
}
