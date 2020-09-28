package com.leetcode.tag.daily.three;

import java.util.*;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Connect {
    /**
     * 算法错误
     * <p>
     * 先序遍历.root->left->right.上一层还没搞定.肯定错误.是层次遍历.
     */
    static class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return root;
            }
            if (root.left != null) {
                if (root.right != null) {
                    root.left.next = root.right;
                } else {
                    Node node = get(root);
                    if (node != null) {
                        if (node.left != null) {
                            root.left.next = node.left;
                        } else {
                            root.left.next = node.right;
                        }
                    }
                }
            }
            if (root.right != null) {
                Node node = get(root);
                if (node != null) {
                    if (node.left != null) {
                        root.right.next = node.left;
                    } else {
                        root.right.next = node.right;
                    }
                }
            }
            connect(root.left);
            connect(root.right);

            return root;

        }

        private Node get(Node node) {
            Node n = node.next;
            while (n != null && n.left == null && n.right == null) {
                n = n.next;
            }
            return n;
        }
    }

    /**
     * 先序遍历
     */
    class Solution1 {
        List<List<Node>> result = new ArrayList<>();

        public Node connect(Node root) {
            pre(root, 0);

            for (List<Node> nodes : result) {
                for (int i = 0; i < nodes.size() - 1; i++) {
                    nodes.get(i).next = nodes.get(i + 1);
                }
            }

            return root;
        }

        private void pre(Node node, int level) {
            if (node == null) {
                return;
            }
            if (result.size() == level) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(node);
            pre(node.left, level + 1);
            pre(node.right, level + 1);
        }

    }

    /**
     * 方法一：层次遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/solution/tian-chong-mei-ge-jie-dian-de-xia-yi-ge-you-ce-15/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            //bfs.队列只是保存每层的数据.
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                for (int i = queue.size(); i > 0; i--) {
                    Node node = queue.poll();
                    //这个条件厉害
                    if (i > 1) {
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

    /**
     * 学习这个
     * <p>
     * 因为必须处理树上的所有节点，所以无法降低时间复杂度，但是可以尝试降低空间复杂度。
     * <p>
     * 正确的先序遍历.厉害.
     */
    class S {
        Map<Integer, Node> map = new HashMap<>();

        public Node connect(Node root) {
            helper(root, 0);
            return root;
        }

        void helper(Node node, int deepth) {
            if (node == null) {
                return;
            }
            if (map.containsKey(deepth)) {
                map.get(deepth).next = node;
            }
            //map不断覆盖同一个深度的结点.同一个深度只保留最后一个结点.
            map.put(deepth, node);
            helper(node.left, deepth + 1);
            helper(node.right, deepth + 1);
        }
    }

    static class Node {
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
