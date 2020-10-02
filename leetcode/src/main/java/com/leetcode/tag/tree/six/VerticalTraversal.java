package com.leetcode.tag.tree.six;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 987. 二叉树的垂序遍历
 */
public class VerticalTraversal {
    class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            pre(root, 0, 0);

            Map<Integer, List<Integer>> linkedHashMap = map.entrySet().stream()
                    .sorted(Map.Entry.comparingByKey())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            linkedHashMap.forEach((k, v) -> {
                Collections.sort(v);
                result.add(v);
            });

            return result;
        }

        private void pre(TreeNode root, int x, int y) {
            if (root == null) {
                return;
            }
            List<Integer> list = map.getOrDefault(x, new ArrayList<>());
            list.add(x);
            map.put(x, list);

            pre(root.left, x - 1, y - 1);
            pre(root.right, x + 1, y - 1);
        }

        private Node post(TreeNode root) {
            if (root == null) {
                return null;
            }
            Node left = post(root.left);
            Node right = post(root.right);
            Node node = new Node(root.val);
            return node;
        }
    }

    class Node {
        int val;
        int x;
        int y;
        TreeNode left;
        TreeNode right;

        Node(int x) {
            val = x;
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
