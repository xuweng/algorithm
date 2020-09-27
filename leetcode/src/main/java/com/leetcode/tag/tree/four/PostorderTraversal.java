package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 145. 二叉树的后序遍历.
 * <p>
 * 变成一颗tree后用bsf.
 * <p>
 * pre.in.post
 */
public class PostorderTraversal {
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            post(root);

            return result;
        }

        private void post(TreeNode root) {
            if (root == null) {
                return;
            }
            post(root.left);
            post(root.right);
            result.add(root.val);
        }
    }

    /**
     * bfs+逆序
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-postorder-traversal/solution/er-cha-shu-de-hou-xu-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }
            LinkedList<TreeNode> stack = new LinkedList<>();
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pollLast();
                output.addFirst(node.val);
                if (node.left != null) {
                    stack.add(node.left);
                }
                if (node.right != null) {
                    stack.add(node.right);
                }
            }
            return output;
        }
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
