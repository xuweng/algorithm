package com.leetcode.tag.tree.two;

/**
 * 1372. 二叉树中的最长交错路径
 * <p>
 * 用一个栈就可以完成遍历,不用cur
 * <p>
 * 用一个栈。不用cur。
 * <p>
 * 虽然简单,就是想不出来
 */
public class LongestZigZag {
    /**
     * 超出时间限制
     * <p>
     * 先序遍历会重复计算
     */
    class Solution {
        int result;

        public int longestZigZag(TreeNode root) {
            pre(root);

            //减掉null结点
            return result - 1;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            pre(root, true, 0);
            pre(root, false, 0);

            pre(root.left);
            pre(root.right);
        }

        /**
         * 算法错误
         *
         * @param root
         * @param isLeft
         * @param count
         */
        private void pre(TreeNode root, boolean isLeft, int count) {
            //是这里统计
            if (root == null) {
                result = Math.max(result, count);
                return;
            }
            if (isLeft) {
                pre(root.right, false, count + 1);
            } else {
                pre(root.left, true, count + 1);
            }

        }
    }

    /**
     * 自底向上树形DP
     * <p>
     * 作者：jackie-tien
     * 链接：https://leetcode-cn.com/problems/longest-zigzag-path-in-a-binary-tree/solution/javazi-di-xiang-shang-shu-xing-dp-by-jackie-tien/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * }
     */
    class Solution1 {
        private int maxPath = 0;

        public int longestZigZag(TreeNode root) {
            dfs(root);

            return maxPath;
        }

        /**
         * 带返回的后序遍历
         * <p>
         * res[0]表示当前节点下一步向左走带来的最大收益，res[1]表示当前节点下一步向右走带来的最大收益
         *
         * @param root
         * @return
         */
        private int[] dfs(TreeNode root) {
            int[] res = new int[2];
            if (root == null) {
                res[0] = -1;
                res[1] = -1;
                return res;
            }
            int[] left = dfs(root.left);
            int[] right = dfs(root.right);
            //res[0]表示当前节点下一步向左走带来的最大收益
            //右----->左
            res[0] = 1 + left[1];
            //res[1]表示当前节点下一步向右走带来的最大收益
            //左------>右
            res[1] = 1 + right[0];
            maxPath = Math.max(maxPath, Math.max(res[0], res[1]));
            return res;
        }
    }

    /**
     * 代码简洁
     */
    class Solution2 {
        int max = 0;

        public int longestZigZag(TreeNode root) {
            dfs(root, true);

            return max;
        }

        /**
         * 带返回的后序遍历.自下往上计算.计算每个结点的结果.每个结点只需要通过left和right计算.类似dp.
         * <p>
         * 搞懂后序遍历
         * <p>
         * 先序+后序
         * <p>
         * 值向下传递+值向上传递
         *
         * @param root
         * @param isLeft
         * @return
         */
        private int dfs(TreeNode root, boolean isLeft) {
            if (root == null) {
                return 0;
            }
            int r = dfs(root.right, false);
            int l = dfs(root.left, true);

            max = Math.max(max, Math.max(l, r));

            //root从左子树下来,需要r+1
            //root从右子树下来,需要l+1
            return isLeft ? r + 1 : l + 1;
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
