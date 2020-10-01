package com.leetcode.tag.tree.five;

import java.util.ArrayList;
import java.util.List;

/**
 * 429. N叉树的层序遍历
 */
public class LevelOrder {
    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(Node root) {
            pre(root, 0);

            return result;
        }

        private void pre(Node root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            for (Node child : root.children) {
                pre(child, level + 1);
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
