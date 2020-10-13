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
            if (head == null) {
                return null;
            }
            Node child = head;
            while (child.next != null) {
                if (child.child != null) {
                    break;
                }
                child = child.next;
            }
            if (child.child == null) {
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
            //注意置为null
            child.child = null;

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
