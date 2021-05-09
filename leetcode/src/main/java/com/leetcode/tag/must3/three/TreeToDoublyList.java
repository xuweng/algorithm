package com.leetcode.tag.must3.three;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表
 */
public class TreeToDoublyList {
    class Solution {
        Node head;
        Node pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            if (root.left == null) {
                head = root;
            }

            dfs(root);

            pre.right = head;
            head.left = pre;

            return head;
        }


        public void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);

            if (root.left == null && root.right == null) {
                // 叶子结点
                // 第一个叶子结点
                head = head == null ? root : head;
            }
            if (pre != null) {
                pre.right = root;
                root.left = pre;
            }
            pre = root;

            dfs(root.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
