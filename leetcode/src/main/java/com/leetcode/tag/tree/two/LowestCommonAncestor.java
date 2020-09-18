package com.leetcode.tag.tree.two;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) {
                return null;
            }
            if (root.val == p.val) {
                return p;
            }
            if (root.val == q.val) {
                return q;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            if (left != null && right != null) {
                return root;
            }

            return (left == null) ? right : left;
        }
    }

    /**
     * 代码简洁
     * <p>
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 递推工作：
         * 当 p,q 都在 root 的 右子树 中，则开启递归 root.right 并返回；
         * 否则，当p,q 都在 root 的 左子树 中，则开启递归 root.left 并返回；
         * 返回值： 最近公共祖先 root 。
         * <p>
         * 作者：jyd
         * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //p和q都在right(不包括root)
            if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            //p和q都在left(不包括root)
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            //p和q有一个是root.直接返回root
            return root;
        }
    }

    class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (null == root) {
                return null;
            }
            if (((root.val <= p.val) && (root.val >= q.val)) || ((root.val >= p.val) && (root.val <= q.val))) {
                return root;
            }
            if (root.val < p.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
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
