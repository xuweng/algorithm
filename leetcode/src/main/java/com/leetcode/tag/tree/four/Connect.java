package com.leetcode.tag.tree.four;

import java.util.ArrayList;
import java.util.List;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    /**
     * 算法错误
     * <p>
     * 先序遍历.root->left->right.上一层还没搞定.肯定错误.是层次遍历.
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    Node node = get(root);
                    if (node != null) {
                        if (node.left != null) {
                            root.left.next = node.left;
                        } else {
                            root.left.next = node.right;
                        }
                    }
                }
            }
            if (root.right != null) {
                Node node = get(root);
                if (node != null) {
                    if (node.left != null) {
                        root.right.next = node.left;
                    } else {
                        root.right.next = node.right;
                    }
                }
            }
            connect(root.left);
            connect(root.right);

            return root;

        }

        private Node get(Node node) {
            Node n = node.next;
            while (n != null && n.left == null && n.right == null) {
                n = n.next;
            }
            return n;
        }
    }

    /**
     * 先序遍历
     */
    class Solution1 {
        List<List<Node>> result = new ArrayList<>();

        public Node connect(Node root) {
            pre(root, 0);

            for (List<Node> nodes : result) {
                for (int i = 0; i < nodes.size() - 1; i++) {
                    nodes.get(i).next = nodes.get(i + 1);
                }
            }

            return root;
        }

        private void pre(Node node, int level) {
            if (node == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node);
            pre(node.left, level + 1);
            pre(node.right, level + 1);
        }

    }

    static class Node {
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
