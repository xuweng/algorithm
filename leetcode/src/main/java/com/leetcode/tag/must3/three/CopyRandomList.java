package com.leetcode.tag.must3.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 */
public class CopyRandomList {
    class Solution {
        public Node copyRandomList(Node head) {
            Node node = head;
            Map<Node, Node> map = new HashMap<>();
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
