package com.leetcode.tag.tree;

import java.util.ArrayList;
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
