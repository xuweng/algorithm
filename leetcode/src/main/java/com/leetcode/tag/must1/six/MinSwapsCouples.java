package com.leetcode.tag.must1.six;

/**
 * 765. 情侣牵手
 */
public class MinSwapsCouples {
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length / 2;
            UF uf = new UF(n);
            for (int i = 0; i < row.length; i += 2) {
                // 情侣不需要union
                uf.union(row[i] / 2, row[i + 1] / 2);
            }

            return n - uf.count;
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
            parent[i1] = i2;
            count--;

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
