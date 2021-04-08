package com.leetcode.tag.must.two;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 排列去重 *前
 */
public class Connect {
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left != null) {
                root.left.next = root.right;
            }
            if (root.next != null && root.right != null) {
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);

            return root;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
