package com.leetcode.tag.tree.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    class Solution {
        Map<Integer, Node> map = new HashMap<>();

        public Node connect(Node root) {
            pre(root, 0);

            return root;
        }

        private void pre(Node root, int level) {
            if (root == null) {
                return;
            }
            if (map.containsKey(level)) {
                map.get(level).next = root;
            }
            map.put(level, root);
            pre(root.left, level + 1);
            pre(root.right, level + 1);
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
