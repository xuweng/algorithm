package com.leetcode.tag.tree;

/**
 * 面试题 04.05. 合法二叉搜索树
 */
public class IsValidBST {
    /**
     * 算法错误
     */
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if (root == null || root.left == null && root.right == null) {
                return true;
            }
            boolean left = isValidBST(root.left);
            boolean right = isValidBST(root.right);

            //算法错误
            //不能只比较一个结点
            //left的最大值和root比较，right的最小值和root比较
            return (root.left.val < root.val && root.val > root.right.val) && left && right;
        }
    }

    /**
     * 作者：xiao-lu-27
     * 链接：https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/solution/dai-qu-jian-de-di-gui-jian-dan-yi-dong-shuang-bai-/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public boolean isValidBST(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isValidBSTHelp(root.left, Long.MIN_VALUE, root.val) && isValidBSTHelp(root.right, root.val, Long.MAX_VALUE);
        }

        /**
         * 这个递归厉害。
         * <p>
         * 带区间的递归.不用马上求最小值和最大值。
         *
         * @param root
         * @param min
         * @param max
         * @return
         */
        private boolean isValidBSTHelp(TreeNode root, long min, long max) {
            if (root == null) {
                return true;
            }
            if (root.val <= min || root.val >= max) {
                return false;
            }
            boolean left = isValidBSTHelp(root.left, min, root.val);
            boolean right = isValidBSTHelp(root.right, root.val, max);

            return left && right;
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
