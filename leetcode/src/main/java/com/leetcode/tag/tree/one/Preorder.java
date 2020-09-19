package com.leetcode.tag.tree.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 */
public class Preorder {
    class Solution {
        public List<Integer> preorder(Node root) {
            if (root == null) {
                return new ArrayList<>();
            }

            List<Integer> result = new ArrayList<>();

            pre(root, result);

            return result;
        }

        private void pre(Node root, List<Integer> result) {
            if (root == null) {
                return;
            }
            result.add(root.val);
            for (Node child : root.children) {
                pre(child, result);
            }

        }
    }

    /**
     * 方法一：迭代
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/ncha-shu-de-qian-xu-bian-li-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        /**
         * 保证栈顶的节点就是我们当前遍历到的节点
         * <p>
         * 把 u 的所有子节点逆序推入栈中
         * <p>
         * 右子树先入栈，这样栈顶是左子树，这样先取出左子树
         *
         * @param root
         * @return
         */
        public List<Integer> preorder(Node root) {
            LinkedList<Node> stack = new LinkedList<>();
            LinkedList<Integer> output = new LinkedList<>();
            if (root == null) {
                return output;
            }

            stack.add(root);
            while (!stack.isEmpty()) {
                Node node = stack.pollLast();
                output.add(node.val);
                //把 u 的所有子节点逆序推入栈中
                Collections.reverse(node.children);
                stack.addAll(node.children);
            }
            return output;
        }
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
