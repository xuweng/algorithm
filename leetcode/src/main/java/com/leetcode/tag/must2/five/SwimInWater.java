package com.leetcode.tag.must2.five;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 778. 水位上升的泳池中游泳
 * <p>
 * 可变参数 可变参数 可变参数
 */
public class SwimInWater {
    class Solution {
        int m;
        int n;

        public int swimInWater(int[][] grid) {
            m = grid.length;
            n = grid[0].length;

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 下一行
                    int a = getIndex(i, j);
                    if (i + 1 < m) {
                        int b = getIndex(i + 1, j);
                        int w = Math.max(grid[i][j], grid[i + 1][j]);
                        list.add(new int[]{a, b, w});
                    }
                    // 右一列
                    if (j + 1 < n) {
                        int b = getIndex(i, j + 1);
                        int w = Math.max(grid[i][j], grid[i][j + 1]);
                        list.add(new int[]{a, b, w});
                    }
                }
            }
            // 按照权重升序
            list.sort(Comparator.comparing(a -> a[2]));

            int start = getIndex(0, 0);
            int end = getIndex(m - 1, n - 1);
            UF uf = new UF(m * n);

            for (int[] ints : list) {
                int a = ints[0], b = ints[1], w = ints[2];
                uf.union(a, b);
                if (uf.isConnect(start, end)) {
                    return w;
                }
            }

            return 0;
        }

        private int getIndex(int i, int j) {
            return i * n + j;
        }
    }

    class UF {
        int count;
        int[] parent;

        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        boolean union(int i, int j) {
            int i1 = find(i);
            int i2 = find(j);
            if (i1 == i2) {
                return false;
            }
            count--;
            parent[i1] = i2;
            return true;
        }

        boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }

        int find(int i) {
            if (i != parent[i]) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }
    }
}
