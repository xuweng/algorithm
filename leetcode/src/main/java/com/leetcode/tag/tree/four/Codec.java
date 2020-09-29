package com.leetcode.tag.tree.four;

/**
 * 449. 序列化和反序列化二叉搜索树
 */
public class Codec {
    private int root;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        pre(root, stringBuilder);

        return stringBuilder.toString();
    }

    private void pre(TreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("#").append(",");
            return;
        }
        stringBuilder.append(root.val).append(",");
        pre(root.left, stringBuilder);
        pre(root.right, stringBuilder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserialize(data.split(","));
    }

    private TreeNode deserialize(String[] data) {
        if ("#".equals(data[root++])) {
            return null;
        }
        TreeNode rootNode = new TreeNode(Integer.parseInt(data[root++]));
        rootNode.left = deserialize(data);
        rootNode.right = deserialize(data);

        return rootNode;
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
