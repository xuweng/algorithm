package com.leetcode.tag.must.five;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 * <p>
 * 模型 模型 模型 模型
 */
public class FindDuplicateSubtrees {
    class Solution {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            if (root == null) {
                return result;
            }
            dfs(root);

            return result;
        }

        private String dfs(TreeNode root) {
            if (root == null) {
                return "#";
            }
            String left = dfs(root.left);
            String right = dfs(root.right);

            String s = root.val + "," + left + "," + right;
            Integer i = map.getOrDefault(s, 0);
            if (i == 1) {
                result.add(root);
            }
            map.put(s, i + 1);

            return s;
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
