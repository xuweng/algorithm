package com.leetcode.tag.dfs.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 133. 克隆图
 * <p>
 * dp.dp.dp.dp.dp
 */
public class CloneGraph {
    class Solution {
        Set<Node> set = new HashSet<>();

        public Node cloneGraph(Node node) {
            if (set.contains(node)) {
                return new Node(node.val);
            }
            set.add(node);
            Node newNode = new Node(node.val, new ArrayList<>());
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
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
