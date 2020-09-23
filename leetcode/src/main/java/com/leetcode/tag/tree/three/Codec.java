package com.leetcode.tag.tree.three;

import java.util.*;

/**
 * 剑指 Offer 37. 序列化二叉树
 * <p>
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/solution/mian-shi-ti-37-xu-lie-hua-er-cha-shu-ceng-xu-bian-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Codec {
    /**
     * 序列化 serialize ：
     * <p>
     * 借助队列，对二叉树做层序遍历，并将越过叶节点的  null 也打印出来
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                res.append("null,");
            } else {
                res.append(node.val).append(",");
                //left为null也会加入队列
                queue.add(node.left);
                //right为null也会加入队列
                queue.add(node.right);
            }
        }
        res.deleteCharAt(res.length() - 1).append("]");

        return res.toString();
    }

    /**
     * 反序列化 deserialize ：
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if ("[]".equals(data)) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //保证i正确
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!Objects.equals(vals[i], "null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.left);
            }
            i++;
            if (!Objects.equals(vals[i], "null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                queue.add(node.right);
            }
            i++;
        }
        return root;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Codec1 {
    List<Integer> list;
    int index;
    // Encodes a tree to a single string.

    /**
     * 先序遍历
     *
     * @param node
     */
    private void func(TreeNode node) {
        if (node == null) {
            list.add(null);
            return;
        }
        list.add(node.val);
        func(node.left);
        func(node.right);

    }

    public String serialize(TreeNode root) {
        list = new ArrayList<>();

        func(root);

        return "";
    }

    /**
     * 先序遍历.先序遍历.
     *
     * @return
     */
    private TreeNode func1() {
        if (index > list.size() - 1) {
            return null;
        }
        //index厉害
        Integer val = list.get(index);
        index++;
        if (val == null) {
            return null;
        }
        TreeNode node = new TreeNode(val);
        node.left = func1();
        node.right = func1();

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;

        return func1();
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