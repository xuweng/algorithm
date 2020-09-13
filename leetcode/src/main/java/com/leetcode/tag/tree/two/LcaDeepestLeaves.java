package com.leetcode.tag.tree.two;

/**
 * 1123. 最深叶节点的最近公共祖先
 * <p>
 * 看不懂题目。直接看答案。
 */
public class LcaDeepestLeaves {
    class Solution {
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            return null;
        }
    }

    /**
     * 如果当前节点是最深叶子节点的最近公共祖先，那么它的左右子树的高度一定是相等的，否则高度低的那个子树的叶子节点深度一定比另一个子树的叶子节点的深度小，
     * <p>
     * 因此不满足条件。所以只需要dfs遍历找到左右子树高度相等的根节点即出答案。
     * <p>
     * 作者：xiaoran-3
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/solution/dfsjian-dan-jie-ti-si-lu-yi-kan-jiu-dong-by-xiaora/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 需要计算每个node的深度，重复遍历
         *
         * @param root
         * @return
         */
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if (root == null) {
                return null;
            }
            int ld = depth(root.left);
            int rd = depth(root.right);
            if (ld == rd) {
                return root;
            } else if (ld > rd) {
                return lcaDeepestLeaves(root.left);
            } else {
                return lcaDeepestLeaves(root.right);
            }
        }

        /**
         * 后序遍历
         * <p>
         * 结果向上传递
         *
         * @param node
         * @return
         */
        public int depth(TreeNode node) {
            return node == null ? 0 : Math.max(depth(node.right), depth(node.left)) + 1;
        }
    }

    /**
     * 如果当前节点是最深叶子节点的最近公共祖先，那么它的左右子树的高度一定是相等的
     * <p>
     * 后序遍历
     * <p>
     * 作者：hundanLi
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/solution/jian-dan-de-hou-xu-bian-li-by-hundanli/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        private TreeNode node;
        private int maxDepth;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            if (root == null) {
                return null;
            }
            dfs(root, 0);
            return node;
        }

        /**
         * 先序遍历+后序遍历
         *
         * @param root
         * @param depth
         * @return
         */
        private int dfs(TreeNode root, int depth) {
            if (root == null) {
                return depth;
            }
            //depth向下传递,depth同时传递给left和right
            depth++;
            int left = dfs(root.left, depth);
            int right = dfs(root.right, depth);
            depth = Math.max(left, right);
            //如果当前节点是最深叶子节点的最近公共祖先，那么它的左右子树的高度一定是相等的
            if (left == right && depth >= maxDepth) {
                node = root;
                maxDepth = depth;
            }
            //不是返回root的深度
            //返回left和right的最大深度
            return depth;
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
