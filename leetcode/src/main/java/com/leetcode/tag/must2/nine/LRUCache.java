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
        // head和tail相连
        head.next = tail;
        tail.pre = head;
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
            Node delete = tail.pre;
            deleteNode(delete);
            // 维护map
            map.remove(delete.key);
        }
        addHead(node);
        // 维护map
        map.put(key, node);
    }

    private void deleteTail() {
        Node pre = tail.pre.pre;
        pre.next = tail;
        tail.pre = pre;
    }

    /**
     * 移动node
     *
     * @param node
     */
    private void moveToHead(Node node) {
        // 删除node
        deleteNode(node);
        // node放入head
        addHead(node);
    }

    /**
     * 删除node
     *
     * @param node
     */
    private void deleteNode(Node node) {
        Node pre = node.pre;
        pre.next = node.next;
        node.next.pre = pre;
    }

    /**
     * node放入head
     *
     * @param node
     */
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
