package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 99. 恢复二叉搜索树
 */
public class RecoverTree {
    /**
     * 以为简单.算法错误.
     */
    class Solution {
        List<TreeNode> list = new ArrayList<>();

        public void recoverTree(TreeNode root) {
            inorder(root);

            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).val > list.get(i + 1).val) {
                    int temp = list.get(i).val;
                    list.get(i).val = list.get(i + 1).val;
                    list.get(i + 1).val = temp;
                    break;
                }
            }
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            list.add(root);
            inorder(root.right);
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
