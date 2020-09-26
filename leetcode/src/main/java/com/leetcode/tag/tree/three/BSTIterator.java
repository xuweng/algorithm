package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 173. 二叉搜索树迭代器
 */
public class BSTIterator {
    List<Integer> result;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        result = new ArrayList<>();
        zhong(root);
        iterator = result.iterator();
    }

    private void zhong(TreeNode root) {
        if (root == null) {
            return;
        }
        zhong(root.left);
        result.add(root.val);
        zhong(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return iterator.hasNext();
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

