package com.leetcode.tag.daily.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 */
public class BuildTree {
    class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        public TreeNode buildTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
            if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
                return null;
            }
            if (inorderStart == inorderEnd || postorderStart == postorderEnd) {
                return new TreeNode(inorder[inorderStart]);
            }
            TreeNode root = new TreeNode(postorder[postorderEnd]);
            int l = map.get(postorder[postorderEnd]);
            //(l - inorderStart)是left结点的数量
            root.left = buildTree(inorder, inorderStart, l - 1, postorder, postorderStart, postorderStart + l - inorderStart - 1);
            root.right = buildTree(inorder, l + 1, inorderEnd, postorder, postorderStart + l - inorderStart, postorderEnd - 1);
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
        //保存root的下标
        int post_idx;
        int[] postorder;
        int[] inorder;
        Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

        public TreeNode helper(int in_left, int in_right) {
            // 如果这里没有节点构造二叉树了，就结束
            if (in_left > in_right) {
                return null;
            }

            // 选择 post_idx 位置的元素作为当前子树根节点
            int root_val = postorder[post_idx];
            TreeNode root = new TreeNode(root_val);

            // 根据 root 所在位置分成左右两棵子树
            int index = idx_map.get(root_val);

            // 下标减一.肯定先构造right.
            post_idx--;
            // 注意这里有需要先创建右子树，再创建左子树的依赖关系
            // 构造右子树
            root.right = helper(index + 1, in_right);
            // 构造左子树
            root.left = helper(in_left, index - 1);
            return root;
        }

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            this.postorder = postorder;
            this.inorder = inorder;
            // 从后序遍历的最后一个元素开始
            post_idx = postorder.length - 1;

            // 建立（元素，下标）键值对的哈希表
            int idx = 0;
            for (Integer val : inorder) {
                idx_map.put(val, idx++);
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
