package com.leetcode.tag.tree.four;

import org.junit.Test;

public class ConnectTest {
    @Test
    public void get() {
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node4.left = node8;
        node7.left = node9;

        Node node = get(node4);
        if (node != null) {
            if (node.left != null) {
                node4.left.next = node.left;
            } else {
                node4.left.next = node.right;
            }
        }

        System.out.println(node4);
    }

    private Node get(Node node) {
        Node n = node.next;
        while (n != null && n.left == null && n.right == null) {
            n = n.next;
        }
        return n;
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