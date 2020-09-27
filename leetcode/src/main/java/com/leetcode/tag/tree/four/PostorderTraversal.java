package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
                //头插法.逆序.
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

    class Solution2 {
        public List<Integer> list = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> st = new Stack<>();
            while (true) {
                while (root != null) {
                    //入栈两次
                    st.push(root);
                    st.push(root);
                    //left
                    root = root.left;
                }
                if (st.isEmpty()) {
                    break;
                }
                root = st.pop();
                if (!st.isEmpty() && st.peek() == root) {
                    //right
                    root = root.right;
                } else {
                    //root
                    list.add(root.val);
                    root = null;
                }
            }
            return list;
        }
    }

    class S {
        public List<Integer> postorderTraversal(TreeNode root) {
            LinkedList<Integer> treeList = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                //与中序不同，不直接pop出来，而是先看看有没有右节点
                TreeNode temp = stack.peek();
                //没有右节点就pop出来进表
                //不要root=stack.pop()，这样root就是最后的null，下一轮就会跳过while循环
                if (temp.right == null) {
                    treeList.add(stack.pop().val);
                }
                //有的话就去遍历右节点，
                //并把当前节点的右节点设为空，否则就无尽循环了，
                //所以要用临时变量temp，
                //root=temp.right后root已变为当前节点的右节点
                //直接root.right=null就是把右节点的右节点设为空了
                else {
                    root = temp.right;
                    temp.right = null;
                }
            }
            return treeList;
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
