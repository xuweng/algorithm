package com.leetcode.tag.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 后序遍历。后序遍历。后序遍历。后序遍历
 * <p>
 * 自顶向下。重复计算。
 * <p>
 * 自底向上。没有重复计算。
 * <p>
 * 814. 二叉树剪枝
 */
public class PruneTree {
    /**
     * 脑海里执行一遍代码
     * <p>
     * 算法错误。包含0的都干掉了。
     */
    class Solution {
        List<TreeNode> list = new ArrayList<>();

        public TreeNode pruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode treeNode = myPruneTree(root);
            if (treeNode == null || treeNode.left == null && treeNode.right == null && treeNode.val == 0) {
                return null;
            }

            return treeNode;
        }

        public TreeNode myPruneTree(TreeNode root) {
            if (root == null) {
                return null;
            }
            if (root.val == 1) {
                list.add(root);
            }

            TreeNode left = myPruneTree(root.left);
            TreeNode right = myPruneTree(root.right);
            //天然获取父节点root
            if (left != null && left.val == 0 && !list.contains(left)) {
                root.left = null;
            }
            if (right != null && right.val == 0 && !list.contains(right)) {
                root.right = null;
            }
            //把结果往上传递
            if (list.contains(left) || list.contains(right)) {
                list.add(root);
            }

            return root;
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
