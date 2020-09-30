package com.leetcode.tag.tree.five;

/**
 * 563. 二叉树的坡度
 */
public class FindTilt {
    class Solution {
        int result;

        public int findTilt(TreeNode root) {
            return root == null ? 0 : Math.abs(dfs(root.left) - dfs(root.right)) + result;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            result += Math.abs(left - right);

            return left + right + root.val;
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-tilt/solution/er-cha-shu-de-po-du-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        int tilt = 0;

        public int findTilt(TreeNode root) {
            traverse(root);
            return tilt;
        }

        public int traverse(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = traverse(root.left);
            int right = traverse(root.right);
            tilt += Math.abs(left - right);
            return left + right + root.val;
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
