package com.leetcode.tag.tree;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 十分钟看题解
 * <p>
 * 思路
 * <p>
 * 思路
 * <p>
 * 思路
 * <p>
 * 刷题效率。刷题效率。刷题效率。
 */
public class CountCompleteTreeNodes {
    class Solution {
        public int countNodes(TreeNode root) {
            return 0;
        }
    }

    /**
     * 方法一：线性时间
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public int countNodes(TreeNode root) {
            return root != null ? 1 + countNodes(root.right) + countNodes(root.left) : 0;
        }
    }

    /**
     * 方法二：二分搜索
     * <p>
     * 方法一没有利用完全二叉树的特性。完全二叉树中，除了最后一层外，其余每层节点都是满的，并且最后一层的节点全部靠向左边
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes/solution/wan-quan-er-cha-shu-de-jie-dian-ge-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        // Return tree depth in O(d) time.
        public int computeDepth(TreeNode node) {
            int d = 0;
            while (node.left != null) {
                node = node.left;
                ++d;
            }
            return d;
        }

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Return True if last level node idx exists.
        // Binary search with O(d) complexity.
        public boolean exists(int idx, int d, TreeNode node) {
            int left = 0, right = (int) Math.pow(2, d) - 1;
            int pivot;
            for (int i = 0; i < d; ++i) {
                pivot = left + (right - left) / 2;
                if (idx <= pivot) {
                    node = node.left;
                    right = pivot;
                } else {
                    node = node.right;
                    left = pivot + 1;
                }
            }
            return node != null;
        }

        public int countNodes(TreeNode root) {
            // if the tree is empty
            if (root == null) {
                return 0;
            }

            int d = computeDepth(root);
            // if the tree contains 1 node
            if (d == 0) {
                return 1;
            }

            // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
            // Perform binary search to check how many nodes exist.
            int left = 1, right = (int) Math.pow(2, d) - 1;
            int pivot;
            while (left <= right) {
                pivot = left + (right - left) / 2;
                if (exists(pivot, d, root)) {
                    left = pivot + 1;
                } else {
                    right = pivot - 1;
                }
            }

            // The tree contains 2**d - 1 nodes on the first (d - 1) levels
            // and left nodes on the last level.
            return (int) Math.pow(2, d) - 1 + left;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
