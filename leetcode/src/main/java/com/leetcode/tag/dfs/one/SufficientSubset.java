package com.leetcode.tag.dfs.one;

/**
 * 1080. 根到叶路径上的不足节点
 * <p>
 * 十分钟.十分钟.
 */
public class SufficientSubset {
    /**
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/insufficient-nodes-in-root-to-leaf-paths/solution/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liweiw/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution {
        /**
         * @param node
         * @param sum
         * @param limit
         * @return 返回 node 结点是否被删除（注意：这个返回值的意义，直接影响整个逻辑。）
         */
        private boolean dfs(TreeNode node, int sum, int limit) {
            if (node.left == null && node.right == null) {
                return sum + node.val < limit;
            }

            // 注意：如果 dfs 的返回值的意义是这个结点是否被删除，它们的默认值应该设置为 true
            boolean leftDeleted = true;
            boolean rightDeleted = true;

            // 如果有左子树，就先递归处理左子树
            if (node.left != null) {
                leftDeleted = dfs(node.left, sum + node.val, limit);
            }
            // 如果有右子树，就先递归处理右子树
            if (node.right != null) {
                rightDeleted = dfs(node.right, sum + node.val, limit);
            }

            // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
            if (leftDeleted) {
                node.left = null;
            }
            if (rightDeleted) {
                node.right = null;
            }

            // 只有左右子树都被删除了，自己才没有必要保留
            return leftDeleted && rightDeleted;
        }

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return dfs(root, 0, limit) ? null : root;
        }
    }

    class Solution1 {
        /**
         * @param node
         * @param s
         * @param limit
         * @return 返回 node 结点是否被保留（注意：这个返回值的意义，直接影响整个逻辑。）
         */
        private Boolean dfs(TreeNode node, int s, int limit) {
            if (node.left == null && node.right == null) {
                return s + node.val >= limit;
            }

            // 注意：如果 dfs 的返回值的意义是这个结点是否被保留，它们的默认值应该设置为 false
            boolean leftSaved = false;
            boolean rightSaved = false;

            // 如果有左子树，就先递归处理左子树
            if (node.left != null) {
                leftSaved = dfs(node.left, s + node.val, limit);
            }

            // 如果有右子树，就先递归处理右子树
            if (node.right != null) {
                rightSaved = dfs(node.right, s + node.val, limit);
            }

            // 左右子树是否保留的结论得到了，由自己来执行是否删除它们
            if (!leftSaved) {
                node.left = null;
            }

            if (!rightSaved) {
                node.right = null;
            }

            // 左右子树有一颗被保留，自己就应该被保留
            return leftSaved || rightSaved;
        }

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            return !dfs(root, 0, limit) ? null : root;
        }
    }

    /**
     * 简洁代码
     */
    class S {
        public TreeNode sufficientSubset(TreeNode root, int limit) {
            if (root == null) {
                return null;
            }
            //到根结点了
            if (root.left == root.right) {
                return root.val < limit ? null : root;
            }
            root.left = sufficientSubset(root.left, limit - root.val);
            root.right = sufficientSubset(root.right, limit - root.val);
            //左右子树都为空，意味着这个子树上没有被保留的路径，那么这个结点也没有保留的必要了
            return root.left == null && root.right == null ? null : root;
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
