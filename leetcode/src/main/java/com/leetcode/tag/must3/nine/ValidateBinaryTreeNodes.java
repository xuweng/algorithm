package com.leetcode.tag.must3.nine;

import java.util.Arrays;

/**
 * 1361. 验证二叉树
 */
public class ValidateBinaryTreeNodes {
    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            UF uf = new UF(n);
            for (int i = 0; i < n; i++) {
                // 唯一
                if (leftChild[i] == rightChild[i] && leftChild[i] != -1) {
                    return false;
                }
                if (!uf.union(i, leftChild[i]) || !uf.union(i, rightChild[i])) {
                    return false;
                }
            }

            return uf.count == 1;
        }
    }

    class UF {
        int count;
        int[] parent;
        int[] nodeFather;

        public UF(int count) {
            this.count = count;
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
            }
            nodeFather = new int[count];
            Arrays.fill(nodeFather, -1);
        }

        boolean union(int i, int j) {
            if (j == -1) {
                // 空结点不需要union
                return true;
            }
            if (nodeFather[j] != -1) {
                // 已经有父结点
                return false;
            }
            int i1 = find(i);
            int i2 = find(j);
            if (i1 == i2) {
                // union会形成环
                return false;
            }
            parent[i1] = i2;
            // 记录父结点
            nodeFather[j] = i;
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
