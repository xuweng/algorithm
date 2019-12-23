package com.algorithm.study.datastructure.tree;

import com.algorithm.study.datastructure.tree.bst.BinaryNode;

public class BinaryTree {
    /**
     * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
     * 根据先根和中根遍历算法构造二叉树
     *
     * @param preList  先根遍历次序数组
     * @param inList   中根遍历次序数组
     * @param preStart
     * @param preEnd
     * @param inStart
     * @param inEnd    return root 最终返回的根结点
     */
    public BinaryNode createBinarySearchTreeByPreIn(Integer[] preList, Integer[] inList, int preStart, int preEnd, int inStart, int inEnd) {
        //preList[preStart]必须根结点数据,创建根结点root
        BinaryNode p = new BinaryNode<>(preList[preStart]);
        //如果没有其他元素,就说明结点已构建完成
        if (preStart == preEnd && inStart == inEnd) {
            return p;
        }
        //找出中根次序的根结点下标root
        int root = 0;

        for (root = inStart; root < inEnd; root++) {
            //如果中根次序中的元素值与先根次序的根结点相当,则该下标index即为inList中的根结点下标
            if (preList[preStart].compareTo(inList[root]) == 0) {
                break;
            }
        }

        //获取左子树的长度
        int leftLength = root - inStart;
        //获取右子树的长度
        int rightLength = inEnd - root;

        //递归构建左子树
        if (leftLength > 0) {
            //左子树的先根序列：preList[1] , ... , preList[i]
            //左子树的中根序列：inList[0] , ... , inList[i-1]
            p.left = createBinarySearchTreeByPreIn(preList, inList, preStart + 1, preStart + leftLength, inStart, root - 1);
        }

        //构建右子树
        if (rightLength > 0) {
            //右子树的先根序列：preList[i+1] , ... , preList[n-1]
            //右子树的中根序列：inList[i+1] , ... , inList[n-1]
            p.right = createBinarySearchTreeByPreIn(preList, inList, preStart + leftLength + 1, preEnd, root + 1, inEnd);
        }

        return p;
    }

    /**
     * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
     * 后根/中根遍历构建二叉树
     *
     * @param postList  后根遍历序列
     * @param inList    中根遍历序列
     * @param postStart
     * @param postEnd
     * @param inStart
     * @param inEnd
     * @return 根结点
     */
    public BinaryNode createBinarySearchTreeByPostIn(Integer[] postList, Integer[] inList, int postStart, int postEnd, int inStart, int inEnd) {
        //构建根结点
        BinaryNode p = new BinaryNode<>(postList[postEnd]);

        if (postStart == postEnd && inStart == inEnd) {
            return p;
        }

        //查找中根序列的根结点下标root
        int root = 0;

        for (root = inStart; root < inEnd; root++) {
            //查找到
            if (postList[postEnd].compareTo(inList[root]) == 0) {
                break;
            }
        }

        //左子树的长度
        int leftLenght = root - inStart;
        //右子树的长度
        int rightLenght = inEnd - root;

        //递归构建左子树
        if (leftLenght > 0) {
            //postStart+leftLenght-1:后根左子树的结束下标
            p.left = createBinarySearchTreeByPostIn(postList, inList, postStart, postStart + leftLenght - 1, inStart, root - 1);
        }

        //递归构建右子树
        if (rightLenght > 0) {
            p.right = createBinarySearchTreeByPostIn(postList, inList, postStart + leftLenght, postEnd - 1, root + 1, inEnd);
        }

        return p;
    }
}
