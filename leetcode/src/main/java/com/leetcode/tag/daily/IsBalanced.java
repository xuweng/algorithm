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
     * 方法一：自顶向下的递归
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/ping-heng-er-cha-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 类似前序遍历
         * <p>
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
            //类似前序遍历
            //计算当前root结点。为true则递归计算左子树和右子树
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);

        }

        public int height(TreeNode root) {
            return root == null ? 0 : Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /**
     * 方法二：自底向上的递归
     */
    class Solution2 {
        /**
         * 类似后序遍历
         * <p>
         * 类似于后序遍历，对于当前遍历到的节点，先递归地判断其左右子树是否平衡，再判断以当前节点为根的子树是否平衡
         *
         * @param root
         * @return
         */
        public boolean isBalanced(TreeNode root) {
            return height(root) >= 0;
        }

        public int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            //如果一棵子树是平衡的，则返回其高度（高度一定是非负整数），否则返回 -1
            if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            } else {
                return Math.max(leftHeight, rightHeight) + 1;
            }
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
