package com.leetcode.tag.tree.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * <p>
 * 没有null.
 * <p>
 * 注意数组越界和下标计算
 */
public class ConstructFromPrePost {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            for (int i = 0; i < post.length; i++) {
                map.put(post[i], i);
            }

            return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
        }

        public TreeNode constructFromPrePost(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
            if (preStart == preEnd || postStart == postEnd) {
                return new TreeNode(pre[preStart]);
            }
            int l = map.get(pre[preStart + 1]);
            TreeNode root = new TreeNode(pre[preStart]);
            root.left = constructFromPrePost(pre, preStart + 1, preStart + l - postStart + 1, post, postStart, l);
            root.right = constructFromPrePost(pre, preStart + l - postStart + 2, preEnd, post, l + 1, postEnd - 1);

            return root;
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
