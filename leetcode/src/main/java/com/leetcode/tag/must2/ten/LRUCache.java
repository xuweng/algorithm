package com.leetcode.tag.must2.ten;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * <p>
 * 3个方法
 */
public class LRUCache {
    int size;
    int capacity;
    Node head;
    Node tail;
    Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
        map = new HashMap<>();
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
            Node delete = tail.pre;
            deleteNode(delete);
            // 维护map
            map.remove(delete.key);
        }
        Node node = new Node(key, value);
        addHead(node);
        // 维护map
        map.put(key, node);
    }

    private void moveHead(Node node) {
        deleteNode(node);
        addHead(node);
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        pre.next = node.next;
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