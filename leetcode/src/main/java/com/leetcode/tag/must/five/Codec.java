package com.leetcode.tag.must.five;

/**
 * 297. 二叉树的序列化与反序列化
 */
public class Codec {
    int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");

        return dfs(split);
    }

    private TreeNode dfs(String[] split) {
        if ("#".equals(split[index])) {
            // 注意++
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
        root.left = dfs(split);
        root.right = dfs(split);

        return root;
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
