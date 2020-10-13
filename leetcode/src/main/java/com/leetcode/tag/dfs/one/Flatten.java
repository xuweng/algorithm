package com.leetcode.tag.dfs.one;

/**
 * 430. 扁平化多级双向链表
 */
public class Flatten {
    class Solution {
        public Node flatten(Node head) {
            dfs(head);

            return head;
        }

        private Node dfs(Node head) {
            Node child = head;
            while (child != null && child.next != null) {
                if (child.child != null) {
                    break;
                }
                child = child.next;
            }
            if (child != null && child.child == null) {
                return child;
            }
            Node node = dfs(child.child);
            node.next = child.next;
            child.next.prev = node;
            child.next = child.child;
            child.child.prev = child;

            Node result = child.child;
            while (result.next != null) {
                result = result.next;
            }
            return result;
        }
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
}
