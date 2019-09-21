package com.jianzi.offer.study.tree;

/**
 * 树
 * <p>
 * 递归:分解、关系(递推公式)、检查
 */
public class Trees {
    /**
     * 递归顺序生成树
     *
     * @param value 结点的值,一般从1开始
     * @param high  树的高度
     * @return
     */
    public static TreeNode generateTree(int value, int high) {
        //输入校验
        if (value <= 0 || high <= 0) {
            throw new IllegalArgumentException();
        }

        TreeNode treeNode = new TreeNode(value, null, null);
        if (high <= 1) {
            return treeNode;
        }
        TreeNode left = generateTree(2 * value, high - 1);
        TreeNode right = generateTree(2 * value + 1, high - 1);
        treeNode.left = left;
        treeNode.right = right;

        return treeNode;
    }

    /**
     * 递归前序遍历
     *
     * @param treeNode
     */
    public static void printfPre(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println("treeNode.value = " + treeNode.value + ",");
        printfPre(treeNode.left);
        printfPre(treeNode.right);
    }

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }
}
