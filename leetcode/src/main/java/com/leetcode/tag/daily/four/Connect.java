package com.leetcode.tag.daily.four;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    class Solution {
        public Node connect(Node root) {
            pre(root);

            return root;
        }

        private void pre(Node root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                root.left.next = root.right;
                pre(root.left);
            }
            if (root.right != null) {
                if (root.next != null) {
                    root.right.next = root.next.left;
                }
                pre(root.right);
            }
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
