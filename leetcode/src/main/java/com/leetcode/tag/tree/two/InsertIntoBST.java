package com.leetcode.tag.tree.two;

/**
 * 701. 二叉搜索树中的插入操作
 * <p>
 * bst天然剪枝.天然剪枝.天然剪枝
 */
public class InsertIntoBST {
    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val <= root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }

            return root;
        }
    }

    class Solution1 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }

            // insert into the right subtree
            if (val > root.val) {
                root.right = insertIntoBST(root.right, val);
            }
            // insert into the left subtree
            else {
                root.left = insertIntoBST(root.left, val);
            }
            return root;
        }
    }

    /**
     * 方法二：迭代
     * <p>
     * 遍历到叶子结点
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/solution/er-cha-sou-suo-shu-zhong-de-cha-ru-cao-zuo-by-le-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            TreeNode node = root;
            while (node != null) {
                // insert into the right subtree
                if (val > node.val) {
                    // insert right now
                    if (node.right == null) {
                        node.right = new TreeNode(val);
                        return root;
                    } else {
                        node = node.right;
                    }
                }
                // insert into the left subtree
                else {
                    // insert right now
                    if (node.left == null) {
                        node.left = new TreeNode(val);
                        return root;
                    } else {
                        node = node.left;
                    }
                }
            }
            return new TreeNode(val);
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
