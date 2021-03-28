package com.leetcode.tag.daily.nine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 */
public class BSTIterator {
    List<Integer> list;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        zhong(root);
        iterator = list.iterator();
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    private void zhong(TreeNode root) {
        if (root == null) {
            return;
        }
        zhong(root.left);
        list.add(root.val);
        zhong(root.right);
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}