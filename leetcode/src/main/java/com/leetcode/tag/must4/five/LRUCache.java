package com.leetcode.tag.must4.five;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存机制
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 * <p>
 * i j 模型
 * <p>
 * 修改前记录 修改前记录 修改前记录
 */
public class LRUCache {
    int capacity;
    int size;
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
            delete(delete);
            map.remove(delete.key);
        }
        Node node = new Node(key, value);
        addHead(node);
        map.put(key, node);
    }

    private void moveHead(Node node) {
        delete(node);
        addHead(node);
    }

    private void addHead(Node node) {
        node.next = head.next;
        head.next.pre = node;

        node.pre = head;
        head.next = node;
    }

    private void delete(Node node) {
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