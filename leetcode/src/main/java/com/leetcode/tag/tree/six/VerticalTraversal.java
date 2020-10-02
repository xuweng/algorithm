package com.leetcode.tag.tree.six;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 987. 二叉树的垂序遍历
 */
public class VerticalTraversal {
    class Solution {
        Map<Integer, List<Node>> map = new HashMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            pre(root, 0, 0);

            Map<Integer, List<Node>> linkedHashMap = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            linkedHashMap.forEach((k, v) -> result.add(v.stream().sorted(Comparator.comparing(Node::getY).reversed()).map(Node::getVal).collect(Collectors.toList())));

            return result;
        }

        private void pre(TreeNode root, int x, int y) {
            if (root == null) {
                return;
            }
            List<Node> list = map.getOrDefault(x, new ArrayList<>());
            list.add(new Node(root.val, x, y));
            map.put(x, list);

            pre(root.left, x - 1, y - 1);
            pre(root.right, x + 1, y - 1);
        }

    }

    class Node {
        int val;
        int x;
        int y;

        Node(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public int getVal() {
            return val;
        }

        public int getY() {
            return y;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
