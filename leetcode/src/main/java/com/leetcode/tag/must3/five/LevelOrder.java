package com.leetcode.tag.must3.five;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null) {
                return new int[0];
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.offerLast(root);

            List<Integer> result = new ArrayList<>();
            while (!deque.isEmpty()) {
                for (int i = 0; i < deque.size(); i++) {
                    TreeNode treeNode = deque.pollFirst();
                    result.add(treeNode.val);
                    if (treeNode.left != null) {
                        deque.offerLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.offerLast(treeNode.right);
                    }
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
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

