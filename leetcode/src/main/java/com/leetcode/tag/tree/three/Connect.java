package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Connect {
    class Solution {
        List<List<Node>> lists = new ArrayList<>();

        public Node connect(Node root) {
            level(root, 0);

            for (List<Node> list : lists) {
                for (int i = 0; i < list.size(); i++) {
                    if (i == list.size() - 1) {
                        list.get(i).next = null;
                    } else {
                        list.get(i).next = list.get(i + 1);
                    }
                }
            }

            return root;
        }

        private void level(Node root, int level) {
            if (root == null) {
                return;
            }
            if (lists.size() == level) {
                lists.add(new ArrayList<>());
            }
            lists.get(level).add(root);
            level(root.left, level + 1);
            level(root.right, level + 1);
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
