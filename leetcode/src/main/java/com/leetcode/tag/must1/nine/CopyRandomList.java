package com.leetcode.tag.must1.nine;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * <p>
 * 二分 二分 二分
 * <p>
 * 二段性 部分有序 旋转数组
 */
public class CopyRandomList {
    class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Node> map = new HashMap<>();
            Node node = head;
            while (node != null) {
                map.put(node, new Node(node.val));
                node = node.next;
            }

            Node node1 = head;
            while (node1 != null) {
                map.get(node1).next = map.get(node1.next);
                map.get(node1).random = map.get(node1.random);

                node1 = node1.next;
            }

            return map.get(head);
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
