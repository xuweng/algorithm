package com.leetcode.tag.tree.three;

/**
 * 669. 修剪二叉搜索树
 * <p>
 * 简洁代码.简洁代码.简洁代码.
 * <p>
 * 递归没有那么清晰.
 * <p>
 * 十分钟没思路看题解.
 * <p>
 * 递归真的是看起来想起来难啊
 * <p>
 * 感觉递归就得靠宏观逻辑，抠细节，哼哼，你就输了
 */
public class TrimBST {
    class Solution {
        public TreeNode trimBST(TreeNode root, int low, int high) {
            if (root == null) {
                return null;
            }
            if (high <= root.val) {
                root.left = trimBST(root.left, low, high);
                root.right = null;
            }
            if (low >= root.val) {
                root.right = trimBST(root.right, low, high);
                root.left = null;
            }
            return root;
        }
    }

    /**
     * 方法：递归
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/trim-a-binary-search-tree/solution/xiu-jian-er-cha-sou-suo-shu-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if (root == null) {
                return root;
            }
            if (root.val > R) {
                return trimBST(root.left, L, R);
            }
            if (root.val < L) {
                return trimBST(root.right, L, R);
            }

            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
