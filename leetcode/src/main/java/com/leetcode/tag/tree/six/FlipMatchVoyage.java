package com.leetcode.tag.tree.six;

import java.util.ArrayList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 */
public class FlipMatchVoyage {
    class Solution {
        int rootIndex;
        boolean flag;
        List<Integer> result = new ArrayList<>();

        public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
            pre(root, null, voyage);

            return result;
        }

        public void pre(TreeNode root, TreeNode parent, int[] voyage) {
            if (root == null || flag) {
                return;
            }
            if (root.val != voyage[rootIndex++]) {
                result.clear();
                result.add(-1);
                flag = true;
                return;
            }
            if (root.left != null) {
                if (root.left.val != voyage[rootIndex]) {
                    int temp = root.left.val;
                    root.left.val = root.right.val;
                    root.right.val = temp;

                    result.add(parent.val);
                }

                pre(root.left, root, voyage);
            }
            if (root.right != null) {
                pre(root.right, root, voyage);
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
