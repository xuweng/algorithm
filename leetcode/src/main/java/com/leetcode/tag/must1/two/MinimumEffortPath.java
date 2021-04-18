package com.leetcode.tag.must1.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
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
                        int a = heights[i][j];
                        int b = heights[i + 1][j];
                        int w = Math.abs(heights[i][j] - heights[i + 1][j]);

                        list.add(new int[]{a, b, w});
                    }
                    // 下一列
                    if (j + 1 < col) {
                        int a = heights[i][j];
                        int b = heights[i][j + 1];
                        int w = Math.abs(heights[i][j] - heights[i][j + 1]);

                        list.add(new int[]{a, b, w});
                    }
                }
            }

            // 按照w升序
            list.sort(Comparator.comparing(a -> a[2]));
            int start = getIndex(0, 0);
            int end = getIndex(row - 1, col - 1);

            UF uf = new UF(row * col);
            for (int[] ints : list) {
                int a = ints[0], b = ints[1], w = ints[2];
                uf.union(a, b);
                if (uf.isConnect(start, end)) {
                    return w;
                }
            }

            return 0;
        }

        int getIndex(int i, int j) {
            return i * col - j;
        }
    }

    class UF {
        int[] parent;
        int count;

        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }

        boolean union(int i, int j) {
            int i1 = find(i);
            int i2 = find(j);
            if (i1 == i2) {
                return false;
            }
            parent[i1] = i2;
            count--;
            return true;
        }

        int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }
    }
}
