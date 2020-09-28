package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> root1s = new ArrayList<>();
            List<Integer> root2s = new ArrayList<>();

            pre(root1, root1s);
            pre(root2, root2s);

            if (root1s.size() != root2s.size()) {
                return false;
            }
            for (int i = 0; i < root1s.size(); i++) {
                if (!root1s.get(i).equals(root2s.get(i))) {
                    return false;
                }
            }

            return true;
        }


        private void pre(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            pre(root.left, result);
            pre(root.right, result);
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
