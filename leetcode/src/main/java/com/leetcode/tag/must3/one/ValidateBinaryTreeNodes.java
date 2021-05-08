package com.leetcode.tag.must3.one;

import java.util.Arrays;

/**
 * 1361. 验证二叉树
 */
public class ValidateBinaryTreeNodes {
    class Solution {
        public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
            UF uf = new UF(n);
            for (int i = 0; i < n; i++) {
                // 结点唯一
                if (leftChild[i] == rightChild[i] && leftChild[i] != -1) {
                    return false;
                }
                if (!uf.union(i, leftChild[i]) || !uf.union(i, rightChild[i])) {
                    return false;
                }
            }

            // 只有一个连通分量才是树
            return uf.count == 1;
        }
    }

    class UF {
        int count;
        int[] parent;
        // 记录结点父结点
        int[] nodeParent;

        UF(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            nodeParent = new int[n];
            Arrays.fill(nodeParent, -1);
        }

        boolean union(int p, int n) {
            if (n == -1) {
                // 空结点不需要union
                return true;
            }
            if (nodeParent[n] != -1) {
                // n已经有父结点
                return false;
            }
            int i = find(p);
            int i1 = find(n);
            if (i == i1) {
                // 连接p，n形成环
                return false;
            }
            parent[i1] = i;
            // 记录父结点
            nodeParent[n] = p;
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
