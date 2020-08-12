package com.leetcode.tag.daily;

import java.util.ArrayList;
import java.util.List;

/**
 * 133. 克隆图
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
     * 无向图-----------死循环
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
}
