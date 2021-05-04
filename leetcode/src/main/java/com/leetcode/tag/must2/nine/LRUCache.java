package com.leetcode.tag.must2.nine;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 */
public class LRUCache {
    int capacity;
    int size;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = tail = new Node(-1, -1);
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            moveToHead(node);
            return;
        }
        size++;
        Node node = new Node(key, value);
        if (size > capacity) {
            deleteTail();
        }
        addHead(node);
    }

    private void deleteTail() {
        Node pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    private void deleteNode(Node node) {
        Node pre = node.pre;
        pre.next = node.next;
        node.next.pre = pre;
    }

    private void moveToHead(Node node) {
        deleteNode(node);
        addHead(node);
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;
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
