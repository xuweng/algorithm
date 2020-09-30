package com.leetcode.tag.tree.five;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1161. 最大层内元素和
 * <p>
 * 十分钟看答案.十分钟看答案.
 * <p>
 * DFS 细分为先序遍历 preorder，中序遍历 inorder 和后序遍历 postorder。
 * <p>
 * DFS 遍历通常有三种实现方式：递归 recursion，迭代 iteration，Morris，其中最简单的是递归。
 * <p>
 * 作者：LeetCode
 * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/solution/zui-da-ceng-nei-yuan-su-he-by-leetcode/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxLevelSum {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int maxLevelSum(TreeNode root) {
            pre(root, 1);

            AtomicInteger levelSum = new AtomicInteger();
            AtomicInteger result = new AtomicInteger();
            map.forEach((k, v) -> {
                if (v > levelSum.get()) {
                    levelSum.set(v);
                    result.set(k);
                }
            });

            return result.get();
        }

        private void pre(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            map.put(depth, map.getOrDefault(depth, 0) + root.val);
            pre(root.left, depth + 1);
            pre(root.right, depth + 1);
        }
    }

    /**
     * 使用数组替换hashmap
     * <p>
     * 遍历时需要记录当前层节点之和。由于 Java 中 HashMap 的性能问题，在 Java 中使用数组，在 Python 中使用 hashmap。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/maximum-level-sum-of-a-binary-tree/solution/zui-da-ceng-nei-yuan-su-he-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int n = 10000;
        int[] levelSum = new int[n];

        /**
         * 遍历时需要记录当前层节点之和。由于 Java 中 HashMap 的性能问题，在 Java 中使用数组，在 Python 中使用 hashmap。
         *
         * @param node
         * @param level
         */
        public void inorder(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            inorder(node.left, level + 1);
            levelSum[level] += node.val;
            inorder(node.right, level + 1);
        }

        public void preorder(TreeNode node, int level) {
            if (node == null) {
                return;
            }
            levelSum[level] += node.val;
            preorder(node.left, level + 1);
            preorder(node.right, level + 1);
        }

        public int maxLevelSum(TreeNode root) {
            preorder(root, 1);

            int maxIdx = 0;
            for (int i = 0; i < n; ++i) {
                maxIdx = levelSum[i] > levelSum[maxIdx] ? i : maxIdx;
            }
            return maxIdx;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
