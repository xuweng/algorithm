package com.leetcode.tag.tree.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    /**
     * bfs
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-j-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    if (i < size - 1) {
                        //队头赋值.厉害.
                        node.next = queue.peek();
                    }

                    //保存非null.先left后right.
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }

    /**
     * 方法二：使用已建立的 next 指针
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-j-3/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            Node leftmost = root;
            while (leftmost.left != null) {
                Node head = leftmost;
                while (head != null) {
                    head.left.next = head.right;
                    if (head.next != null) {
                        head.right.next = head.next.left;
                    }
                    head = head.next;
                }
                leftmost = leftmost.left;
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
