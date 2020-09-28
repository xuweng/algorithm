package com.leetcode.tag.tree.four;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    /**
     * 算法错误
     */
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    if (root.next != null) {
                        if (root.next.left != null) {
                            root.left.next = root.next.left;
                        } else {
                            root.left.next = root.next.right;
                        }
                    }
                }
            }
            if (root.right != null && root.next != null) {
                if (root.next.left != null) {
                    root.right.next = root.next.left;
                } else {
                    root.right.next = root.next.right;
                }
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
