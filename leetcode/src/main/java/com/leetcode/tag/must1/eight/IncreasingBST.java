package com.leetcode.tag.must1.eight;

import java.util.ArrayList;
import java.util.List;

/**
 * 897. 递增顺序搜索树
 */
public class IncreasingBST {
    class Solution {
        TreeNode pre;

        public TreeNode increasingBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode result = findMin(root);
            dfs(root);

            return result;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre != null) {
                pre.right = root;
                root.left = null;
            }
            pre = root;

            dfs(root.right);
        }

        TreeNode findMax(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode node = root;
            while (node.right != null) {
                node = node.right;
            }

            return node;
        }


        TreeNode findMin(TreeNode root) {
            if (root == null) {
                return null;
            }
            TreeNode node = root;
            while (node.left != null) {
                node = node.left;
            }

            return node;
        }
    }

    /**
     * 方法二：在中序遍历的过程中改变节点指向
     */
    class Solution1 {
        private TreeNode resNode;

        public TreeNode increasingBST(TreeNode root) {
            // 亚结点
            TreeNode dummyNode = new TreeNode(-1);
            // 亚结点开始遍历
            resNode = dummyNode;

            inorder(root);

            return dummyNode.right;
        }

        public void inorder(TreeNode node) {
            if (node == null) {
                return;
            }
            inorder(node.left);

            // 在中序遍历的过程中修改节点指向
            resNode.right = node;
            node.left = null;
            resNode = node;

            inorder(node.right);
        }
    }

    /**
     * 方法一：中序遍历之后生成新的树
     */
    class Solution2 {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            inorder(root, res);

            TreeNode dummyNode = new TreeNode(-1);
            TreeNode currNode = dummyNode;
            for (int value : res) {
                currNode.right = new TreeNode(value);
                currNode = currNode.right;
            }
            return dummyNode.right;
        }

        public void inorder(TreeNode node, List<Integer> res) {
            if (node == null) {
                return;
            }
            inorder(node.left, res);
            res.add(node.val);
            inorder(node.right, res);
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
