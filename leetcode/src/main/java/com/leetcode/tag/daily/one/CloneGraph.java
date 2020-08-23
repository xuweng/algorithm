package com.leetcode.tag.daily.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 133. 克隆图。
 * <p>
 * dfs和bfs是重点。
 * <p>
 * 十分钟看答案。
 * <p>
 * 十分钟看答案。
 */
public class CloneGraph {
    /**
     * 深拷贝即构建一张与原图结构，值均一样的图，但是其中的节点不再是原来图节点的引用
     * <p>
     * 图的遍历。
     * <p>
     * 为了避免在深拷贝时陷入死循环，我们需要理解图的结构。对于一张无向图，任何给定的无向边都可以表示为两个有向边，
     * <p>
     * 即如果节点 A 和节点 B 之间存在无向边，则表示该图具有从节点 A 到节点 B 的有向边和从节点 B 到节点 A 的有向边。
     * <p>
     * 无向图-----------死循环.死循环。死循环。死循环。死循环。死循环。死循环。
     */
    class Solution {
        public Node cloneGraph(Node node) {
            return null;
        }
    }

    /**
     * 每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）
     */
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * 方法一：深度优先搜索
     * <p>
     * 时间复杂度：O(N)
     * <p>
     * 空间复杂度：O(N)
     * <p>
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/clone-graph/solution/ke-long-tu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Solution1 {
        private HashMap<Node, Node> visited = new HashMap<>();

        public Node cloneGraph(Node node) {
            if (node == null) {
                return node;
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
                //克隆邻接列表后重新加入当前结点
                cloneNode.neighbors.add(cloneGraph(neighbor));
            }
            return cloneNode;
        }
    }

    /**
     * 方法二：广度优先遍历
     * <p>
     * 时间复杂度：O(N)
     * <p>
     * 空间复杂度：O(N)
     * <p>
     * 方法一与方法二的区别仅在于搜索的方式。
     * <p>
     * 深度优先搜索以深度优先，广度优先搜索以广度优先。
     * <p>
     * 先搞定一个分支，再搞定另外一个分支。
     * <p>
     * 这两种方法都需要借助哈希表记录被克隆过的节点来避免陷入死循环。
     * <p>
     * 图遍历之死循环。
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

            HashMap<Node, Node> visited = new HashMap();

            // 将题目给定的节点添加到队列
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(node);
            // 克隆第一个节点并存储到哈希表中
            visited.put(node, new Node(node.val, new ArrayList()));

            // 广度优先搜索
            while (!queue.isEmpty()) {
                // 取出队列的头节点
                Node n = queue.remove();
                // 遍历该节点的邻居
                for (Node neighbor : n.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        // 如果没有被访问过，就克隆并存储在哈希表中
                        visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                        // 将邻居节点加入队列中
                        queue.add(neighbor);
                    }
                    // 更新当前节点的邻居列表
                    visited.get(n).neighbors.add(visited.get(neighbor));
                }
            }

            return visited.get(node);
        }
    }


}
