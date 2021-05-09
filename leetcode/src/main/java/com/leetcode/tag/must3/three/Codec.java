package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 配匹完 配匹完 配匹完 二分 二分 二分
 * <p>
 * 二分 二分 二分
 * <p>
 * 归并 归并 归并
 * <p>
 * 快排 快排 快排
 * <p>
 * head head head
 */
public class Codec {
    int root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        // 先序遍历
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");

        return dfs(split);
    }

    private TreeNode dfs(String[] split) {
        if ("#".equals(split[root])) {
            return null;
        }
        // 先序遍历
        TreeNode node = new TreeNode(Integer.parseInt(split[root++]));
        node.left = dfs(split);
        node.right = dfs(split);

        return node;
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
