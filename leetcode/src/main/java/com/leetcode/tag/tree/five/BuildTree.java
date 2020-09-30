package com.leetcode.tag.tree.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
                return null;
            }
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
            if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
                return null;
            }

            TreeNode root = new TreeNode(postorder[postorderEnd]);
            int rootIndex = map.get(postorder[postorderEnd]);
            root.left = buildTree(inorder, inorderStart, rootIndex - 1, postorder, postorderStart, postorderStart + rootIndex - inorderStart - 1);
            root.right = buildTree(inorder, rootIndex + 1, inorderEnd, postorder, postorderStart + rootIndex - inorderStart, postorderEnd - 1);

            return root;
        }
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/cong-zhong-xu-yu-hou-xu-bian-li-xu-lie-gou-zao-14/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        //这个下标厉害
        int postIndex;
        int[] postorder;
        int[] inorder;
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode helper(int inLeft, int inRight) {
            // 如果这里没有节点构造二叉树了，就结束
            if (inLeft > inRight) {
                return null;
            }
            // 选择 post_idx 位置的元素作为当前子树根节点
            TreeNode root = new TreeNode(postorder[postIndex--]);
            // 根据 root 所在位置分成左右两棵子树
            int index = map.get(postorder[postIndex]);
            // 构造右子树
            root.right = helper(index + 1, inRight);
            // 构造左子树
            root.left = helper(inLeft, index - 1);
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.inorder = inorder;
            // 从后序遍历的最后一个元素开始
            postIndex = postorder.length - 1;

            // 建立（元素，下标）键值对的哈希表
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return helper(0, inorder.length - 1);
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
}
