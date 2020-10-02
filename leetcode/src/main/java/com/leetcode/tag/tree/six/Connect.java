package com.leetcode.tag.tree.six;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

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

    /**
     * bfs
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 1; i <= n; ++i) {
                    Node node = queue.poll();
                    if (i < n) {
                        node.next = queue.peek();
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root;
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
