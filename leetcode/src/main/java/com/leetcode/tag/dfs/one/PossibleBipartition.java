package com.leetcode.tag.dfs.one;

/**
 * 886. 可能的二分法
 * <p>
 * 排列:重复是正确的.
 * <p>
 * 排序去重.厉害.排序厉害.排序厉害.
 * <p>
 * 简洁代码.简洁代码.简洁代码.
 * <p>
 * 图.邻接矩阵.邻接表.
 * <p>
 * 想到图.想到图.想到图.
 * <p>
 * 环.判断图是否有环.并查集.
 */
public class PossibleBipartition {
    class Solution {
        public boolean possibleBipartition(int N, int[][] dislikes) {
            if (dislikes == null || dislikes.length == 0) {
                return true;
            }
            UF uf = new UF(N + 1);
            for (int[] dislike : dislikes) {
                if (!uf.union(dislike[0], dislike[1])) {
                    return false;
                }
            }

            return true;
        }
    }

    class UF {
        int[] parents;

        public UF(int n) {
            this.parents = new int[n];

            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }

            return parents[i];
        }

        public boolean union(int i, int j) {
            int iRoot = find(i);
            int jRoot = find(j);
            if (iRoot == jRoot) {
                return false;
            }
            parents[iRoot] = jRoot;
            return true;
        }
    }
}
