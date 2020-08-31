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
            //root当作最大值传入left
            //root当作最小值传入right
            return isValidBSTHelp(root.left, Long.MIN_VALUE, root.val) && isValidBSTHelp(root.right, root.val, Long.MAX_VALUE);
        }

        /**
         * 先序遍历。结果往下传。
         * <p>
         * 后序遍历。结果往上传。
         * <p>
         * 不用遍历子树的所有结点?
         * <p>
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

    class Solution2 {
        /**
         * 参数太多。
         * <p>
         * 封装数据结构。
         */
        class res {
            boolean bol;
            long min;
            long max;

            res(boolean x, long y, long z) {
                bol = x;
                min = y;
                max = z;
            }
        }

        public boolean isValidBST(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            res left = isValidBST_do(root.left);
            res right = isValidBST_do(root.right);

            return root.val > left.max && root.val < right.min && left.bol && right.bol;
        }

        /**
         * 后序遍历
         *
         * @param root
         * @return
         */
        public res isValidBST_do(TreeNode root) {
            if (root == null) {
                return new res(true, Long.MAX_VALUE, Long.MIN_VALUE);
            }
            res left = isValidBST_do(root.left);
            res right = isValidBST_do(root.right);

            boolean temp = (root.val > left.max && root.val < right.min);

            //三者比较
            long max = Math.max(Math.max(left.max, right.max), root.val);
            long min = Math.min(Math.min(left.min, right.min), root.val);

            return new res(temp, min, max);

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
