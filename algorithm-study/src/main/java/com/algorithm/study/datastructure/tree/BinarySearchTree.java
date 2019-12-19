package com.algorithm.study.datastructure.tree;

/**
 * 二叉查找树
 */
public class BinarySearchTree {
    private BinaryNode<Integer> root;

    /**
     * 插入
     *
     * @param root
     * @param date
     * @return
     */
    public BinaryNode<Integer> insert(BinaryNode<Integer> root, Integer date) {
        if (root == null) {
            return new BinaryNode<Integer>(date, null, null);
        }

        if (date < root.date) {
            root.left = insert(root.left, date);
        } else if (date > root.date) {
            root.right = insert(root.right, date);
        }

        return root;
    }

    /**
     * 查找
     *
     * @param root
     * @param date
     * @return
     */
    public BinaryNode<Integer> find(BinaryNode<Integer> root, Integer date) {
        if (root == null) {
            return null;
        }

        if (date < root.date) {
            return find(root.left, date);
        } else if (date > root.date) {
            return find(root.right, date);
        } else {
            return root;
        }

    }

    /**
     * 二叉结点
     *
     * @param <T>
     */
    static class BinaryNode<T> {
        private T date;
        private BinaryNode left;
        private BinaryNode right;

        BinaryNode(T date) {
            this.date = date;
        }

        public BinaryNode(T date, BinaryNode left, BinaryNode right) {
            this.date = date;
            this.left = left;
            this.right = right;
        }

        public boolean isLeafNode() {
            return (this.left == null) && (this.right == null);
        }

    }

    /**
     * 三叉结点
     *
     * @param <T>
     */
    static class ThreeNode<T> {
        private T date;
        private ThreeNode parent;
        private ThreeNode left;
        private ThreeNode right;

        ThreeNode(T date) {
            this.date = date;
        }

        public ThreeNode(T date, ThreeNode left, ThreeNode right) {
            this.date = date;
            this.left = left;
            this.right = right;
        }

        public boolean isLeafNode() {
            return (this.left == null) && (this.right == null);
        }

        public ThreeNode(T date, ThreeNode parent, ThreeNode left, ThreeNode right) {
            this.date = date;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }
}
