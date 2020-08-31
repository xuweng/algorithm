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

    /**
     * 后序遍历的返回太重要了
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-pruning/solution/er-cha-shu-jian-zhi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode pruneTree(TreeNode root) {
            return containsOne(root) ? root : null;
        }

        /**
         * 也是把结果往上传递
         * <p>
         * 用 containsOne(node) 函数来判断以 node 为根的子树中是否包含 1，其不包含 1 当且仅当以 node 的左右孩子为根的子树均不包含 1
         * <p>
         * 并且 node 节点本身的值也不为 1
         * <p>
         * 作者：LeetCode
         * 链接：https://leetcode-cn.com/problems/binary-tree-pruning/solution/er-cha-shu-jian-zhi-by-leetcode/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param node
         * @return
         */
        public boolean containsOne(TreeNode node) {
            if (node == null) {
                return false;
            }
            boolean a1 = containsOne(node.left);
            boolean a2 = containsOne(node.right);
            if (!a1) {
                //不包含1
                node.left = null;
            }
            if (!a2) {
                //不包含1
                node.right = null;
            }
            //条件是root，left，right都判断
            return node.val == 1 || a1 || a2;
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
