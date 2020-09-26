package com.leetcode.tag.tree.three;

/**
 * 1026. 节点与其祖先之间的最大差值
 */
public class MaxAncestorDiff {
    class Solution {
        int max;
        int result;

        public int maxAncestorDiff(TreeNode root) {
            pre(root);

            return result;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                pre(root.left, root.val);
                result = Math.max(result, max);
                max = 0;
            }
            if (root.right != null) {
                pre(root.right, root.val);
                result = Math.max(result, max);
                max = 0;
            }

            pre(root.left);
            pre(root.right);
        }

        private void pre(TreeNode root, int val) {
            if (root == null) {
                return;
            }
            max = Math.max(max, Math.abs(val - root.val));
            pre(root.left, val);
            pre(root.right, val);
        }

    }

    /**
     * dfs.厉害.
     * <p>
     * 作者：mmmmmJCY
     * 链接：https://leetcode-cn.com/problems/maximum-difference-between-node-and-ancestor/solution/java-dfs-by-zxy0917-4/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int res = Integer.MIN_VALUE;

        public int maxAncestorDiff(TreeNode root) {
            if (root == null) {
                return 0;
            }
            //如果当前节点没有子节点，则直接返回
            helper(root, root.val, root.val);
            return res;
        }

        /**
         * 每条从根节点到叶子节点的路径中的最大值和最小值，并求出差值更新全局变量
         */
        private void helper(TreeNode node, int max, int min) {
            if (node == null) {
                return;
            }
            max = Math.max(node.val, max);
            min = Math.min(node.val, min);
            //到达叶子节点，求最大差值
            if (node.left == null && node.right == null) {
                res = Math.max(res, Math.abs(max - min));
            }
            helper(node.left, max, min);
            helper(node.right, max, min);
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
