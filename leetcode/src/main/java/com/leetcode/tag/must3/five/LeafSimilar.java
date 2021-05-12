package com.leetcode.tag.must3.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 872. 叶子相似的树
 */
public class LeafSimilar {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            dfs(root1, list1);
            dfs(root2, list2);

            return list1.equals(list2);
        }

        private void dfs(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            list.add(root.val);
            dfs(root.left, list);
            dfs(root.right, list);
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
