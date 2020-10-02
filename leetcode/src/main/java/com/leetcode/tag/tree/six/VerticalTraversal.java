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

            linkedHashMap.forEach((k, v) -> result.add(v.stream()
                    .sorted(Comparator.comparing(Node::getVal))
                    .sorted(Comparator.comparing(Node::getY).reversed())
                    .map(Node::getVal).collect(Collectors.toList())));

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

    /**
     * 方法一：记录坐标
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/solution/er-cha-shu-de-chui-xu-bian-li-by-leetcode-2/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        List<Location> locations;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // Each location is a node's x position, y position, and value
            locations = new ArrayList<>();
            dfs(root, 0, 0);
            Collections.sort(locations);

            List<List<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<>());

            int prev = locations.get(0).x;

            for (Location loc : locations) {
                // If the x value changed, it's part of a new report.
                if (loc.x != prev) {
                    prev = loc.x;
                    ans.add(new ArrayList<>());
                }

                // We always add the node's value to the latest report.
                ans.get(ans.size() - 1).add(loc.val);
            }

            return ans;
        }

        public void dfs(TreeNode node, int x, int y) {
            if (node == null) {
                return;
            }
            locations.add(new Location(x, y, node.val));
            dfs(node.left, x - 1, y + 1);
            dfs(node.right, x + 1, y + 1);
        }
    }

    class Location implements Comparable<Location> {
        int x, y, val;

        Location(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        /**
         * x 坐标排序，再根据 y 坐标排序，最后是val排序
         *
         * @param that
         * @return
         */
        @Override
        public int compareTo(Location that) {
            if (this.x != that.x) {
                return Integer.compare(this.x, that.x);
            } else if (this.y != that.y) {
                return Integer.compare(this.y, that.y);
            } else {
                return Integer.compare(this.val, that.val);
            }
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
