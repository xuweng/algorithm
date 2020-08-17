package com.leetcode.tag.daily;

public class IsBalanced {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return true;
        }

        /**
         * 层次遍历.
         * <p>
         * 层次遍历。
         *
         * @param root
         * @return
         */
        public int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 具体做法类似于二叉树的前序遍历，即对于当前遍历到的节点，首先计算左右子树的高度，
         * <p>
         * 如果左右子树的高度差是否不超过 1，再分别递归地遍历左右子节点，并判断左子树和右子树是否平衡
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        }

        public int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
