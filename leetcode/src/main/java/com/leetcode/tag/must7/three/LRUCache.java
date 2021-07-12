package com.leetcode.tag.must7.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 16.25. LRU 缓存
 */
public class LRUCache {
    Map<Integer, Node> map;
    int size;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveHead(node);
            return;
        }
        size++;
        if (size > capacity) {
            Node pre = tail.pre;
            map.remove(pre.key);
            delete(pre);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addHead(node);
    }

    private void moveHead(Node node) {
        delete(node);
        addHead(node);
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.pre = node;

        head.next = node;
        node.pre = head;
    }

    private void delete(Node node) {
        Node pre = node.pre;
        pre.next = pre.next.next;
        node.next.pre = pre;
    }


    class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
