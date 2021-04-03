package com.leetcode.tag.must.seven;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 04.09. 二叉搜索树序列
 */
public class BSTSequences {
    class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> BSTSequences(TreeNode root) {
            List<TreeNode> wait = new ArrayList<>();
            if (root != null) {
                wait.add(root);
            }
            backtrack(wait, new ArrayList<>());
            return res;
        }

        private void backtrack(List<TreeNode> wait, List<Integer> curList) {
            if (wait.size() == 0) {
                res.add(new ArrayList<>(curList));
                return;
            }
            int size = wait.size();
            for (int i = 0; i < size; ++i) {
                TreeNode cur = wait.remove(0);
                curList.add(cur.val);
                if (cur.left != null) {
                    wait.add(cur.left);
                }
                if (cur.right != null) {
                    wait.add(cur.right);
                }
                backtrack(wait, curList);
                curList.remove(curList.size() - 1);
                if (cur.left != null) {
                    wait.remove(wait.size() - 1);
                }
                if (cur.right != null) {
                    wait.remove(wait.size() - 1);
                }
                wait.add(cur);
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
