package com.leetcode.tag.dfs.one;

import java.util.*;

/**
 * 133. 克隆图
 * <p>
 * dp.dp.dp.dp.dp
 */
public class CloneGraph {
    class Solution {
        Map<Node, Node> hashMap = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            if (hashMap.containsKey(node)) {
                return hashMap.get(node);
            }
            Node newNode = new Node(node.val, new ArrayList<>());
            //先标记node已经clone.再递归.
            hashMap.put(node, newNode);
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        private final HashMap<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            // 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
            if (visited.containsKey(node)) {
                return visited.get(node);
            }

            // 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
            Node cloneNode = new Node(node.val, new ArrayList<>());
            // 哈希表存储
            visited.put(node, cloneNode);

            // 遍历该节点的邻居并更新克隆节点的邻居列表
            for (Node neighbor : node.neighbors) {
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }

    /**
     * 方法二：广度优先遍历
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution2 {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
            }

            HashMap<Node, Node> visited = new HashMap<>();

            // 将题目给定的节点添加到队列
            Queue<Node> queue = new LinkedList<>();
            queue.offer(node);
            // 克隆第一个节点并存储到哈希表中
            visited.put(node, new Node(node.val, new ArrayList<>()));

            // 广度优先搜索
            while (!queue.isEmpty()) {
                // 取出队列的头节点
                Node n = queue.poll();
                // 遍历该节点的邻居
                for (Node neighbor : n.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        // 如果没有被访问过，就克隆并存储在哈希表中
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                        // 将邻居节点加入队列中
                        queue.offer(neighbor);
                    }
                    // 更新当前节点的邻居列表
                    visited.get(n).neighbors.add(visited.get(neighbor));
                }
            }

            return visited.get(node);
        }
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
