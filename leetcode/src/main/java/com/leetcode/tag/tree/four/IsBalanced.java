package com.leetcode.tag.tree.four;

/**
 * 面试题 04.04. 检查平衡性
 */
public class IsBalanced {
    class Solution {
        boolean result = true;

        public boolean isBalanced(TreeNode root) {
            height(root);

            return result;
        }

        private int height(TreeNode root) {
            if (root == null || !result) {
                return 0;
            }
            int left = height(root.left);
            int right = height(root.right);
            if (Math.abs(left - right) > 1) {
                result = false;
            }
            return Math.max(left, right) + 1;
        }
    }

    /**
     * 作者：zui-weng-jiu-xian
     * 链接：https://leetcode-cn.com/problems/check-balance-lcci/solution/xin-shou-di-gui-jie-fa-by-zui-weng-jiu-xian/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isBalanced(TreeNode root) {
            // 根结点为null，说明是棵空树，认为是平衡的
            if (root == null) {
                return true;
            }
            int leftTreeDepth = treeDepth(root.left);   // 左子树高度
            int rightTreeDepth = treeDepth(root.right); // 右子树高度
            if (Math.abs(leftTreeDepth - rightTreeDepth) > 1) {
                return false;   // 高度差大于1说明不平衡
            }
            // 若以当前节点为根的子树是平衡的，继续递归检查它左右子树的平衡性
            return isBalanced(root.left) && isBalanced(root.right);
        }

        public int treeDepth(TreeNode root) {
            return root == null ? 0 : Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
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
