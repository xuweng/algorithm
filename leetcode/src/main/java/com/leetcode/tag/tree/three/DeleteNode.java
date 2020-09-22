package com.leetcode.tag.tree.three;

/**
 * 450. 删除二叉搜索树中的节点
 * <p>
 * 3个状态.搞清楚多少个状态.
 */
public class DeleteNode {
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key && root.left == null && root.right == null) {
                return null;
            }
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }
            if (root.val > key) {
                root.left = deleteNode(root.left, key);
            }
            if (root.left != null) {

            }
            if (root.right != null) {

            }

            return root;
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/shan-chu-er-cha-sou-suo-shu-zhong-de-jie-dian-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /*
        One step right and then always left
        */
        public int successor(TreeNode root) {
            root = root.right;
            while (root.left != null) {
                root = root.left;
            }
            return root.val;
        }

        /*
        One step left and then always right
        */
        public int predecessor(TreeNode root) {
            root = root.left;
            while (root.right != null) {
                root = root.right;
            }
            return root.val;
        }

        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }

            // delete from the right subtree
            if (key > root.val) {
                root.right = deleteNode(root.right, key);
            }
            // delete from the left subtree
            else if (key < root.val) {
                root.left = deleteNode(root.left, key);
            }
            // delete the current node
            else {
                // the node is a leaf
                if (root.left == null && root.right == null) {
                    root = null;
                }
                // the node is not a leaf and has a right child
                else if (root.right != null) {
                    root.val = successor(root);
                    root.right = deleteNode(root.right, root.val);
                }
                // the node is not a leaf, has no right child, and has a left child
                else {
                    root.val = predecessor(root);
                    root.left = deleteNode(root.left, root.val);
                }
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
