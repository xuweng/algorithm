package com.jianzi.offer.study.tree;

import java.util.Objects;

/**
 * 树
 * <p>
 * 递归:分解、关系(递推公式)、检查
 * <p>
 * 递归:通过改变函数参数进行递归
 * <p>
 * 分治:缩小数据规模(改变函数参数)
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

    /**
     * 重建二叉树
     * <p>
     * 递归:通过改变函数参数进行递归
     * 分解、关系、检查
     * <p>
     * 2个指针划分3部分,1个指针划分为2部分
     *
     * @param preArray    前序序列
     * @param middleArray 中序序列
     */
    public static TreeNode constructBinaryTree(int[] preArray, int preStart, int preEnd, int[] middleArray, int middleStart, int middleEnd) {
        Objects.requireNonNull(preArray);
        Objects.requireNonNull(middleArray);

        int rootValue = preArray[preStart];
        TreeNode treeNode = new TreeNode(rootValue, null, null);
        if (preStart >= preEnd || middleStart >= middleEnd) {
            return treeNode;
        }

        int rootIndex = findIndex(middleArray, rootValue, middleStart, middleEnd);
        //左子树个数
        int leftNumber = rootIndex - middleStart;
        int leftIndex = preStart + leftNumber;

        TreeNode left = constructBinaryTree(preArray, preStart + 1, leftIndex, middleArray, middleStart, rootIndex - 1);
        TreeNode right = constructBinaryTree(preArray, leftIndex + 1, preEnd, middleArray, rootIndex + 1, middleEnd);

        treeNode.left = left;
        treeNode.right = right;

        return treeNode;

    }

    /**
     * 根据值查找索引
     *
     * @param array
     * @param value
     * @param start
     * @param end
     * @return 索引
     */
    public static int findIndex(int[] array, int value, int start, int end) {
        Objects.requireNonNull(array);
        if (start < 0 || end > array.length) {
            throw new IllegalArgumentException();
        }
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return 0;
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
