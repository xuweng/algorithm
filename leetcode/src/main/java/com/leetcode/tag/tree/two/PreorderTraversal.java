package com.leetcode.tag.tree.two;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 */
public class PreorderTraversal {
    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            pre(root);

            return result;
        }

        private void pre(TreeNode root) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            pre(root.left);
            pre(root.right);
        }
    }

    /**
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-de-qian-xu-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.push(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.poll();
                output.add(node.val);
                //right先入栈
                if (node.right != null) {
                    stack.add(node.right);
                }
                //left后入栈,后进先出
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
            return output;
        }
    }

    class Solution2 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;

            //两个条件
            while (cur != null || !stack.isEmpty()) {
                while (cur != null) {
                    //root
                    list.add(cur.val);
                    stack.push(cur);
                    //left
                    cur = cur.left;
                }
                cur = stack.pop();
                //right
                //cur.right可能为null,cur可能为null
                cur = cur.right;

            }
            return list;
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

