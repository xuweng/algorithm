package com.leetcode.tag.must1.one;

/**
 * 765. 情侣牵手
 * <p>
 * 移动后比较
 */
public class MinSwapsCouples {
    class Solution {
        public int minSwapsCouples(int[] row) {
            int n = row.length;
            int dui = n / 2;
            UF uf = new UF(dui);
            for (int i = 0; i < n; i += 2) {
                // 成对情侣不需要union
                uf.union(row[i] / 2, row[i + 1] / 2);
            }

            return dui - uf.count;
        }
    }

    class UF {
        int[] parent;
        int count;
        int size;

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
            int j1 = find(j);
            if (i1 == j1) {
                return false;
            }
            parent[i1] = j1;
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
